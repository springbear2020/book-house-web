package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.pojo.User;
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
    protected void downloadBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        /*
         * 客户端请求：transferServlet?action=downloadBook&bookId=${book.id}&userId=${sessionScope.user.id}
         * transferServlet?action=downloadBook&bookId=${requestScope.book.id}&userId=${sessionScope.user.id}
         * 确保了 userId 和 bookId 不会越界
         */
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), Book.ERROR);
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        HttpSession session = req.getSession();

        // 用户为登录则跳转到登录页面
        if (session.getAttribute("user") == null) {
            session.setAttribute("noticeMsg", "请您先登录账号哦");
            req.getRequestDispatcher("/WEB-INF/pages/user/login.jsp").forward(req, resp);
            return;
        }
        // 查询用户积分，积分不足不准下载
        int userScore = userService.getUserScore(userId);
        if (userScore < User.SCORE_CHANGE) {
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
            NOTIFICATIONS.add("您刚刚下载了《" + book.getTitle() + "》，积分 -10。" + DateUtil.dateFormatTime(new Date()));
            session.setAttribute("notifications", NOTIFICATIONS);
            // 添加图书下载量、减少用户积分、添加用户图书下载记录、用户下载量加 1（触发器完成）TODO
            boolean b = bookService.addBookDownloads(Book.ADD_DOWNLOAD, bookId);
            boolean b1 = userService.subUserScore(User.SCORE_CHANGE, userId);
            boolean b2 = recordService.saveDownload(new Download(null, userId, "下载图书", "-" + User.SCORE_CHANGE, new Date(), book.getTitle()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过路径下载文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void downloadFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getParameter("path");
        String fileName = path.substring(path.lastIndexOf('/'));
        // 读取文件类型
        String mimeType = getServletContext().getMimeType("/file/" + path);
        // 通过响应头通知客户端返回的数据类型
        resp.setContentType(mimeType);
        // 告知客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 从磁盘读取想要下载的字节数据到流中
        InputStream inputStream = getServletContext().getResourceAsStream("/" + path);
        // 复制流中数据到响应输出流，复制出错则抛出异常
        IOUtils.copy(inputStream, resp.getOutputStream());
    }

    /**
     * 用户上传图书文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = new User();
        Object obj = session.getAttribute("user");
        if (obj instanceof User) {
            user = (User) obj;
        }
        Upload upload = new Upload(null, user.getId(), user.getUsername(), "上传图书", "+" + User.SCORE_CHANGE, new Date(), null, null, null, "未处理");
        // 判断表单是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析表单的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    // 非普通表单项，进行文件下载
                    if (!fileItem.isFormField()) {
                        // type="file" 表单项，获取文件数据
                        String fieldName = fileItem.getFieldName();
                        String fileName = DateUtil.dateFormatFilename(new Date());
                        if ("book".equals(fieldName)) {
                            String bookPath = DataUtil.getUploadSavePath() + upload.getUserId() + "-" + fileName + ".pdf";
                            // 将用户上传的图书文件写入本地磁盘，文件名为用户名加当前时间加 book.pdf
                            fileItem.write(new File(getServletContext().getRealPath("/") + bookPath));
                            // 设置书名和图书保存路径
                            upload.setTitle(fileItem.getName());
                            upload.setBookPath(bookPath);
                        } else if ("cover".equals(fieldName)) {
                            String coverPath = DataUtil.getUploadSavePath() + upload.getUserId() + "-" + fileName + ".png";
                            // 将用户上传的封面文件写入本地磁盘，文件名为用户名加当前时间加 cover.png
                            fileItem.write(new File(getServletContext().getRealPath("/") + coverPath));
                            upload.setCoverPath(coverPath);
                        }
                    }
                }

                // 添加用户上传记录，用户上传量加 1（触发器完成）
                if (recordService.saveUpload(upload)) {
                    session.setAttribute("noticeMsg", "图书上传成功，待管理员审核后发放积分到您的账号，感谢您的共享");
                    NOTIFICATIONS.add("您刚刚上传了《" + upload.getTitle() + "》，积分 +10。" + DateUtil.dateFormatTime(new Date()));
                    session.setAttribute("notifications", NOTIFICATIONS);
                } else {
                    session.setAttribute("noticeMsg", "图书文件上传失败，请您稍后重试");
                }
                req.getRequestDispatcher("/WEB-INF/pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                session.setAttribute("noticeMsg", "图书文件上传失败，请您稍后重试");
                req.getRequestDispatcher("/WEB-INF/pages/book/upload.jsp").forward(req, resp);
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
                        // 更新用户头像数据库保存路径 TODO
                        boolean b = userService.updateUserPortrait("static/picture/portrait/" + userId + ".png", userId);
                        session.setAttribute("noticeMsg", "头像更换成功");
                        session.setAttribute("user", userService.getUserById(userId));
                        req.getRequestDispatcher("/WEB-INF/pages/user/personal.jsp").forward(req, resp);
                    }
                }
            } catch (Exception e) {
                session.setAttribute("noticeMsg", "头像更换失败，请稍后重试");
                req.getRequestDispatcher("/WEB-INF/pages/user/personal.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadPixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 判断表单是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析表单的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    // 非普通表单项即文件表单项，保存到 static/picture/background/time.png
                    if (!fileItem.isFormField()) {
                        fileItem.write(new File(getServletContext().getRealPath("/") + "static/picture/background/" + DateUtil.dateFormatFilename(new Date()) + ".png"));
                        req.getRequestDispatcher("/WEB-INF/pages/admin/admin.jsp").forward(req, resp);
                    }
                }
            } catch (Exception e) {
                req.getRequestDispatcher("/WEB-INF/pages/error/400.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }

    /**
     * 管理员图书上传
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void processBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Book book = new Book(null, null, null, null, null, 0, 0, null, null, null, null, new Date());
        int userId = -1;
        int uploadId = -1;
        String bookPath = "";
        String coverPath = "";
        HttpSession session = req.getSession();
        // 判断上传的文件是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析上传数据的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                // 逐条解析文件数据，分普通表单项和文件进行处理
                for (FileItem fileItem : fileItemList) {
                    // 普通表单项，读取 name - value 信息并封装为 Book 对象
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");
                        switch (name) {
                            case "title":
                                book.setTitle(value);
                                break;
                            case "author":
                                book.setAuthor(value);
                                break;
                            case "translator":
                                book.setTranslator(value);
                                break;
                            case "keywords":
                                book.setKeywords(value);
                                break;
                            case "comment":
                                book.setComment(value);
                                break;
                            case "uploadUsername":
                                book.setUploadUsername(value);
                                break;
                            case "userId":
                                userId = NumberUtil.objectToInteger(value, User.ERROR);
                                break;
                            case "uploadId":
                                uploadId = NumberUtil.objectToInteger(value, Upload.ERROR);
                                break;
                            case "bookPath":
                                bookPath = value;
                                break;
                            case "coverPath":
                                coverPath = value;
                                break;
                            default:
                        }
                    } else {
                        // 非普通表单项，获取文件信息；获取文件表单项的 name 属性值
                        String fieldName = fileItem.getFieldName();
                        // 获取上传的文件名
                        String uploadFileName = fileItem.getName();
                        if ("book".equals(fieldName)) {
                            // 将图书文件保存到磁盘真实路径下目录下 /WEB-INF/book/
                            fileItem.write(new File(getServletContext().getRealPath("/") + "/WEB-INF/book/" + uploadFileName));
                            // 设置图书文件经服务器部署后的相对路径为 bookWebPath
                            book.setBookPath("WEB-INF/book/" + uploadFileName);
                        } else if ("cover".equals(fieldName)) {
                            // 将封面文件保存到磁盘真实路径下
                            fileItem.write(new File(getServletContext().getRealPath("/") + "/static/picture/cover/" + uploadFileName));
                            // 设置封面文件相对路径为 coverWebPath
                            book.setCoverPath("static/picture/cover/" + uploadFileName);
                        }
                    }
                }

                // 保存图书记录到数据库、增加用户积分、删除磁盘文件、修改上传记录状态为已处理
                if (bookService.saveBook(book)) {
                    bookPath = getServletContext().getRealPath("/" + bookPath);
                    coverPath = getServletContext().getRealPath("/" + coverPath);
                    File bookFile = new File(bookPath);
                    File coverFile = new File(coverPath);
                    // 删除磁盘文件、修改上传记录状态为已处理、增加用户积分
                    if (bookFile.exists() && coverFile.exists() && bookFile.delete() && coverFile.delete() && recordService.updateUploadState(uploadId) && userService.addUserScore(10, userId)) {
                        session.setAttribute("noticeMsg", "Process successfully");
                        resp.sendRedirect(req.getContextPath() + "/WEB-INF/pages/admin/manage.jsp");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/WEB-INF/pages/error/500.jsp");
                    }
                } else {
                    session.setAttribute("noticeMsg", "Process failed");
                    req.getRequestDispatcher("/WEB-INF/pages/admin/manage.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                session.setAttribute("noticeMsg", "Process failed");
                req.getRequestDispatcher("/WEB-INF/pages/admin/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }
}
