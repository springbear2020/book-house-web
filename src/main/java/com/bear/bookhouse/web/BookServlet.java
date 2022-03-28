package com.bear.bookhouse.web;


import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.util.DataUtil;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    protected void showBooks(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 页码为空则默认加载第 1 页
        int pageNum = NumberUtil.objectToInteger(req.getParameter("pageNum"), Page.DEFAULT_SHOW_PAGE);
        String title = req.getParameter("title");
        HttpSession session = req.getSession();
        Page<Book> bookPageData;

        if (title != null) {
            // 根据书名查询图书数据
            bookPageData = bookService.getBookPageDataByTitle(pageNum, DataUtil.getPageSize(), title);
            req.setAttribute("title", title);
        } else {
            // 查询所有图书数据
            bookPageData = bookService.getBookPageData(pageNum, DataUtil.getPageSize());
            req.removeAttribute("title");
        }
        // 查询到的图书数据为空
        if (bookPageData == null || bookPageData.getPageData() == null || bookPageData.getPageData().size() == 0) {
            session.setAttribute("noticeMsg", "您查询的图书暂无数据");
        }
        req.setAttribute("bookPageData", bookPageData);
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

    /**
     * 显示图书详情
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBookDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("book", bookService.getBookById(NumberUtil.objectToInteger(req.getParameter("bookId"), Book.ERROR)));
        req.getRequestDispatcher("/WEB-INF/pages/book/detail.jsp").forward(req, resp);
    }

    /**
     * 图书详情页随机展示一本图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBookRandomly(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", bookService.getOneBookRandomly());
        req.getRequestDispatcher("/WEB-INF/pages/book/detail.jsp").forward(req, resp);
    }
}
