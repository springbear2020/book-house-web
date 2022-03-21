package com.bear.bookhouse.servlet;


import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.util.NumberUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 19:42
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    /**
     * 指定页码获取图书数据，每页默认 5 条数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void listBooksByPageNum(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageNumStr = req.getParameter("pageNum");
        int pageNum = NumberUtil.objectToInteger(pageNumStr, 1);
        // 获取图书分页数据
        Page<Book> bookPageData = bookService.getBookPageData(pageNum, 5);
        if (bookPageData != null) {
            req.setAttribute("bookPageData", bookPageData);
            req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/pages/error/500.jsp");
        }
    }

    /**
     * 图书上传
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取图书保存路径和图书封面保存路径
        ServletContext servletContext = getServletContext();
        String bookPath = servletContext.getRealPath("/WEB-INF/book/");
        Book book = new Book();
        book.setBookPath(bookPath + "book/");
        book.setBookCoverPath(bookPath + "cover/");

        // TODO 等待解决图书上传写入磁盘问题
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
                            case "uploadUsername":
                                book.setUploadUsername(value);
                                break;
                            case "title":
                                book.setTitle(value);
                                break;
                            case "author":
                                book.setAuthor(value);
                                break;
                            case "keywords":
                                book.setKeywords(value);
                                break;
                            default:
                        }
                    } else {
                        // 非普通表单项，获取文件信息；获取文件表单项的 name 属性值
                        String fieldName = fileItem.getFieldName();
                        // 上传的文件名
                        String uploadFileName = fileItem.getName();
                        if ("book".equals(fieldName)) {
                            // 设置图书文件保存路径并将文件写到磁盘
                            String bookFileSavePath = book.getBookPath() + uploadFileName;
                            book.setBookPath(bookFileSavePath);
                            fileItem.write(new File(bookFileSavePath));
                        } else {
                            // 设置图书封面文件保存路径并将文件写到磁盘
                            String bookCoverFileSavePath = book.getBookCoverPath() + uploadFileName;
                            book.setBookCoverPath(bookCoverFileSavePath);
                            fileItem.write(new File(bookCoverFileSavePath));
                        }
                    }
                }
                book.setCollections(0);
                book.setDownloads(0);
                book.setUploadTime(new Date());
                // 保存图书记录到数据库
                if (bookService.saveBook(book)) {
                    req.setAttribute("uploadMsg", "图书文件上传成功，待管理员审核后发放对应积分到您的账号，感谢您的共享");
                } else {
                    req.setAttribute("uploadMsg", "服务器繁忙，图书文件上传失败，请稍后重试");
                }
                req.getRequestDispatcher("/pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("uploadMsg", "服务器繁忙，图书文件上传失败，请稍后重试");
                req.getRequestDispatcher("/pages/book/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }
}
