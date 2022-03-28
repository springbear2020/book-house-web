package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.*;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.DataUtil;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 15:47
 */
public class RecordServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    /**
     * 显示用户上传或下载记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        int pageNum = NumberUtil.objectToInteger(req.getParameter("pageNum"), Page.DEFAULT_SHOW_PAGE);
        String type = req.getParameter("type");

        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 ID 不合法");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        // 根据 type 分别查询下载或上传记录
        if (Download.TYPE.equals(type)) {
            // 查询用户下载记录
            Page<Download> recordPage = recordService.getDownloadPageData(userId, pageNum, DataUtil.getRecordPageSize());
            if (recordPage == null || recordPage.getPageData() == null || recordPage.getPageData().size() == 0) {
                session.setAttribute("noticeMsg", "暂无下载记录，快去下载图书吧");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }
            req.setAttribute("recordPage", recordPage);
            req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
        } else if (Upload.TYPE.equals(type)) {
            // 查询用户上传记录
            Page<Upload> recordPage = recordService.getUploadPageData(userId, pageNum, DataUtil.getRecordPageSize());
            if (recordPage == null || recordPage.getPageData() == null || recordPage.getPageData().size() == 0) {
                session.setAttribute("noticeMsg", "暂无上传记录，快去上传图书吧");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }
            req.setAttribute("recordPage", recordPage);
            req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
        } else {
            session.setAttribute("noticeMsg", "记录请求类型不合法");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    /**
     * 显示用户登录记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showLog(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        int pageNum = NumberUtil.objectToInteger(req.getParameter("pageNum"), Page.DEFAULT_SHOW_PAGE);
        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 ID 不合法");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        // 查询用户个人登录记录
        Page<LoginLog> loginLogPage = recordService.getLoginLogPageData(userId, pageNum, DataUtil.getRecordPageSize());
        req.setAttribute("loginLogPage", loginLogPage);
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }

    /**
     * 添加用户收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 客户端 favoriteServlet?action=addFavorite&bookId=${book.id}&userId=${sessionScope.user.id}&title=${book.title} 确保了 id 不会越界
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), Book.ERROR);
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String coverPath = req.getParameter("coverPath");
        HttpSession session = req.getSession();

        // 查询用户图书收藏记录是否已经存在
        if (recordService.isFavoriteExists(userId, bookId)) {
            session.setAttribute("noticeMsg", "图书收藏记录已存在，不可重复收藏");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        // 保存收藏记录、增加图书收藏量、用户收藏量增加 1（由触发器完成）
        if (recordService.addFavorite(new Favorite(null, userId, bookId, title, author, coverPath, new Date())) && bookService.addBookFavorites(Book.ADD_Favorite, bookId)) {
            session.setAttribute("noticeMsg", "图书加入收藏夹成功");
        } else {
            session.setAttribute("noticeMsg", "图书加入收藏夹失败，请稍后重试");
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除用户收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deleteFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 客户端请求：favoriteServlet?action=deleteFavorite&userId=${sessionScope.user.id}&bookId=${favorite.bookId} 确保 id 不会越界
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), Book.ERROR);
        HttpSession session = req.getSession();

        // 删除用户收藏记录，用户收藏量减 1（由触发器完成）
        if (!recordService.deleteUserFavorite(userId, bookId)) {
            session.setAttribute("noticeMsg", "图书取消收藏失败，请稍后重试");
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 通过用户 id 查询用户收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showFavorites(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        // 验证用户 id 是否合法

        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 id 不合法");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        // 从数据库查询用户个人收藏记录
        List<Favorite> userFavorites = recordService.getUserFavorites(userId);
        if (userFavorites == null || userFavorites.size() == 0) {
            session.setAttribute("noticeMsg", "个人收藏夹暂无数据，赶快收藏图书吧");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("userFavoritesList", userFavorites);
            req.getRequestDispatcher("/pages/book/favorite.jsp").forward(req, resp);
        }
    }
}
