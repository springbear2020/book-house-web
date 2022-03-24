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
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        HttpSession session = req.getSession();

        // 查询用户积分，积分不足则不准下载
        int userScore = userService.getUserScore(userId);
        if (userScore < 10) {
            session.setAttribute("scoreMsg", "您的积分不足，暂时不能下载图书哦");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
            return;
        }
        // 读取文件类型
        String mimeType = getServletContext().getMimeType("/file/" + book.getBookPath());
        // 通过响应头通知客户端返回的数据类型
        resp.setContentType(mimeType);
        // 告知客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(DateUtil.fileNameFormat(new Date()) + ".pdf", "UTF-8"));
        // 从磁盘读取想要下载的字节数据到流中
        InputStream inputStream = getServletContext().getResourceAsStream("/" + book.getBookPath());
        // 将文件字节流数据赋值给响应输出流
        IOUtils.copy(inputStream, resp.getOutputStream());

        // 图书下载量增加 1，用户积分减少 10
        boolean b1 = bookService.addBookDownloads(bookId);
        boolean b = userService.subUserScore(userId);
    }

    /**
     * 用户上传图书文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Record record = new Record();
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");
                        if ("userId".equals(name)) {
                            record.setUserId(NumberUtil.objectToInteger(value, -1));
                        }
                    } else {
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
                if (recordService.addRecord(record)) {
                    req.setAttribute("userUploadMsg", "图书上传成功，感谢您的共享");
                    // 用户积分增加 10
                    boolean b = userService.addUserScore(record.getUserId());
                } else {
                    req.setAttribute("userUploadMsg", "图书文件上传失败，请您稍后重试");
                }
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("userUploadMsg", "图书文件上传失败，请您稍后重试");
                req.getRequestDispatcher("pages/book/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }
}
