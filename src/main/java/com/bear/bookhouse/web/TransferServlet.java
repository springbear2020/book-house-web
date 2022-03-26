package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.DataUtil;
import com.bear.bookhouse.util.DateUtil;
import com.bear.bookhouse.util.NumberUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 16:38
 */
public class TransferServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();
    private static final List<String> NOTIFICATIONS = new ArrayList<>();

    /**
     * 通过图书 id 下载对应的图书数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void downloadBook(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        /*
         * 客户端请求：transferServlet?action=downloadBook&bookId=${book.id}&userId=${sessionScope.user.id}
         *            transferServlet?action=downloadBook&bookId=${requestScope.book.id}&userId=${sessionScope.user.id}
         * 确保了 userId 和 bookId 不会越界
         */
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        HttpSession session = req.getSession();

        // 查询用户积分，积分不足则不准下载
        int userScore = userService.getUserScore(userId);
        if (userScore < DataUtil.getScoreChange()) {
            session.setAttribute("noticeMsg", "您的积分不足，暂时不能下载图书哦，快去上传图书获取积分吧");
            try {
                resp.sendRedirect(req.getHeader("Referer"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        Book book = bookService.getBookById(bookId);
        // 读取文件类型
        String mimeType = getServletContext().getMimeType("/file/" + book.getBookPath());
        // 通过响应头通知客户端返回的数据类型
        resp.setContentType(mimeType);
        // 告知客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(book.getTitle() + ".pdf", "UTF-8"));
        // 从磁盘读取想要下载的字节数据到流中
        InputStream inputStream = getServletContext().getResourceAsStream("/" + book.getBookPath());
        try {
            // 复制流中数据到响应输出流，复制出错则抛出异常
            IOUtils.copy(inputStream, resp.getOutputStream());
            NOTIFICATIONS.add("您刚刚下载了《" + book.getTitle() + "》，积分 -10。" + DateUtil.timeFormat(new Date()));
            session.setAttribute("notifications", NOTIFICATIONS);
            // 添加图书下载量、减少用户积分、添加用户图书下载记录
            bookService.addBookDownloads(1, bookId);
            userService.subUserScore(DataUtil.getScoreChange(), userId);
            recordService.saveDownload(new Download(null, userId, "下载图书", "-" + DataUtil.getScoreChange(), new Date(), book.getTitle()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户上传图书文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Upload upload = new Upload(null, null, "上传图书", "+" + DataUtil.getScoreChange(), new Date(), null);
        HttpSession session = req.getSession();
        // 判断表单是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析表单的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    // 普通表单项，获取 name 和 value 属性值
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");
                        if ("userId".equals(name)) {
                            // 客户端请求 userId = ${sessionScope.user.id} 确保了 userId 不会越界
                            upload.setUserId(NumberUtil.objectToInteger(value, -1));
                        }
                    } else {
                        // type="file" 表单项，获取文件数据
                        String fieldName = fileItem.getFieldName();
                        if ("book".equals(fieldName)) {
                            // 将用户上传的图书文件写入本地磁盘，文件名为用户名加当前时间加 book.pdf
                            fileItem.write(new File(getServletContext().getRealPath("/") + DataUtil.getUploadSavePath() + upload.getUserId() + "-" + DateUtil.fileNameFormat(new Date()) + "-book.pdf"));
                            // 设置书名
                            upload.setTitle(fileItem.getName());
                        } else if ("cover".equals(fieldName)) {
                            // 将用户上传的封面文件写入本地磁盘，文件名为用户名加当前时间加 cover.png
                            fileItem.write(new File(getServletContext().getRealPath("/") + DataUtil.getUploadSavePath() + upload.getUserId() + "-" + DateUtil.fileNameFormat(new Date()) + "-cover.png"));
                        }
                    }
                }

                // TODO 待管理员审核后下发积分
                // 添加用户上传记录、增加用户积分
                if (recordService.saveUpload(upload) && userService.addUserScore(DataUtil.getScoreChange(), upload.getUserId())) {
                    session.setAttribute("noticeMsg", "图书上传成功，待管理员审核后发放积分到您的账号，感谢您的共享");
                    NOTIFICATIONS.add("您刚刚上传了《" + upload.getTitle() + "》，积分 +10。" + DateUtil.timeFormat(new Date()));
                    session.setAttribute("notifications", NOTIFICATIONS);
                } else {
                    session.setAttribute("noticeMsg", "图书文件上传失败，请您稍后重试");
                }
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                session.setAttribute("noticeMsg", "图书文件上传失败，请您稍后重试");
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }

    /**
     * 用户上传头像
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadPortrait(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        // 判断表单是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析表单的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    // 非普通表单项即文件表单项，保存到 static/picture/portrait/userId.png
                    if (!fileItem.isFormField()) {
                        fileItem.write(new File(getServletContext().getRealPath("/") + "static/picture/portrait/" + userId + ".png"));
                        // 更新用户头像数据库保存路径
                        userService.updatePortrait("static/picture/portrait/" + userId + ".png", userId);
                        session.setAttribute("noticeMsg", "头像更换成功");
                        session.setAttribute("user", userService.getUserById(userId));
                        req.getRequestDispatcher("pages/user/personal.jsp").forward(req, resp);
                    }
                }
            } catch (Exception e) {
                session.setAttribute("noticeMsg", "头像更换失败，请稍后重试");
                req.getRequestDispatcher("pages/user/personal.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }
}
