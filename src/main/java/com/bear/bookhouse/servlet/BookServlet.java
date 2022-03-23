package com.bear.bookhouse.servlet;


import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 19:42
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

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
