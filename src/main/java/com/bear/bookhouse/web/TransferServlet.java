package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Record;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
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
import java.net.URLEncoder;
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

    /**
     * 通过图书 id 下载对应的图书数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void downloadBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        if (userScore < 10) {
            session.setAttribute("downloadBookMsg", "您的积分不足，暂时不能下载图书哦，快去上传图书获取积分吧");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        Book book = bookService.getBookById(bookId);
        // 读取文件类型
        String mimeType = getServletContext().getMimeType("/file/" + book.getBookPath());
        // 通过响应头通知客户端返回的数据类型
        resp.setContentType(mimeType);
        // 告知客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(DateUtil.fileNameFormat(new Date()) + ".pdf", "UTF-8"));
        // 从磁盘读取想要下载的字节数据到流中
        InputStream inputStream = getServletContext().getResourceAsStream("/" + book.getBookPath());
        // 图书下载量增加 1，用户积分减少 10，添加用户下载记录，将文件字节流数据赋值给响应输出流
        bookService.addBookDownloads(bookId);
        userService.subUserScore(userId);
        recordService.addRecord(new Record(null, userId, "下载图书", "-10", new Date(), book.getTitle()));
        IOUtils.copy(inputStream, resp.getOutputStream());
    }

    /**
     * 用户上传图书文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Record record = new Record();
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
                            record.setUserId(NumberUtil.objectToInteger(value, -1));
                        }
                    } else {
                        // type="file" 表单项，获取文件数组
                        String fieldName = fileItem.getFieldName();
                        String uploadFileName = fileItem.getName();
                        if ("book".equals(fieldName)) {
                            // 将用户上传的图书文件写入本地磁盘
                            fileItem.write(new File(getServletContext().getRealPath("/") + "/WEB-INF/upload/" + DateUtil.fileNameFormat(new Date()) + uploadFileName));
                            record.setTitle(uploadFileName);
                        } else if ("cover".equals(fieldName)) {
                            // 将用户上传的图书封面文件写入本地磁盘
                            fileItem.write(new File(getServletContext().getRealPath("/") + "/static/picture/upload/" + DateUtil.fileNameFormat(new Date()) + uploadFileName));
                        }
                    }
                }

                record.setTime(new Date());
                record.setOperation("上传图书");
                record.setScoreChange("+10");
                // 用户积分增加 10 分 TODO 待管理员审核后下发积分
                if (recordService.addRecord(record) && userService.addUserScore(record.getUserId())) {
                    session.setAttribute("uploadBookMsg", "图书上传成功，待管理员审核后下发积分到您的账号，感谢您的共享");
                } else {
                    session.setAttribute("uploadBookMsg", "图书文件上传失败，请您稍后重试");
                }
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("uploadBookMsg", "图书文件上传失败，请您稍后重试");
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }
}
