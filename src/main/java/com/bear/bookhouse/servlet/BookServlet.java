package com.bear.bookhouse.servlet;


import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.DownloadService;
import com.bear.bookhouse.service.UploadService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.DownloadServiceImpl;
import com.bear.bookhouse.service.impl.UploadServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 19:42
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();
    private final DownloadService downloadService = new DownloadServiceImpl();
    private final UploadService uploadService = new UploadServiceImpl();

    /**
     * 显示图书下载记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBookRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        String type = req.getParameter("type");
        HttpSession session = req.getSession();
        // 图书下载记录
        if ("download".equals(type)) {
            List<Download> downloadList = downloadService.getUserDownload(userId);
            if (downloadList == null || downloadList.size() == 0) {
                session.setAttribute("queryRecordMsg", "暂无下载记录，赶快去下载图书吧");
                resp.sendRedirect(req.getHeader("Referer"));
                return;
            }
            req.setAttribute("title", "下载记录");
            req.setAttribute("type", "download");
            req.setAttribute("downloadList", downloadList);
        } else if ("upload".equals(type)) {
            // 图书上传记录
            List<Upload> uploadList = uploadService.getUploadRecord(userId);
            if (uploadList == null || uploadList.size() == 0) {
                session.setAttribute("queryRecordMsg", "暂无上传记录，赶快去上传图书吧");
                resp.sendRedirect(req.getHeader("Referer"));
                return;
            }
            req.setAttribute("title", "上传记录");
            req.setAttribute("type", "upload");
            req.setAttribute("uploadList", uploadList);
        }
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }

    /**
     * 显示图书详情
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBookDetailsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("bookId");
        int id = NumberUtil.objectToInteger(idStr, -1);
        Book book = bookService.getBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/book/detail.jsp").forward(req, resp);
    }

    /**
     * 指定页码获取图书数据，每页默认 5 条数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void listBooksByPageNum(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageNumStr = req.getParameter("pageNum");
        // 页码错误则默认加载第 1 页
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
}
