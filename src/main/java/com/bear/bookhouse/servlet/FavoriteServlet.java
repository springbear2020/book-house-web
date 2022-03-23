package com.bear.bookhouse.servlet;

import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.FavoriteService;
import com.bear.bookhouse.service.impl.FavoriteServiceImpl;
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
 * @datetime 2022/3/22 21:18
 */
public class FavoriteServlet extends BaseServlet {
    private final FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 删除收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deleteFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        HttpSession session = req.getSession();
        if (userId == -1 || bookId == -1) {
            session.setAttribute("deleteFavoritesMsg", "图书取消收藏失败，请稍后重试");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        if (favoriteService.deleteUserFavorite(userId, bookId)) {
            session.setAttribute("deleteFavoritesMsg", "图书取消收藏成功");
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            session.setAttribute("deleteFavoritesMsg", "图书取消收藏失败，请稍后重试");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    /**
     * 添加收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void addFavoriteRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String translator = req.getParameter("translator");

        HttpSession session = req.getSession();
        if (userId == -1 || bookId == -1) {
            session.setAttribute("addFavoriteMsg", "图书加入收藏夹失败，请稍后重试");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        // 查询用户图书收藏记录是否已经存在
        if (favoriteService.isFavoriteExists(userId, bookId)) {
            session.setAttribute("addFavoriteMsg", "图书已收藏，不可重复收藏");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        if (favoriteService.addFavorite(new Favorite(null, userId, bookId, title, author, translator, new Date()))) {
            session.setAttribute("addFavoriteMsg", "图书加入收藏夹成功");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 通过用户 id 查询用户收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void getFavoritesByUserId(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userIdStr = req.getParameter("userId");
        int userId = NumberUtil.objectToInteger(userIdStr, -1);
        HttpSession session = req.getSession();
        if (userId == -1) {
            session.setAttribute("getFavoritesMsg", "查询个人收藏夹失败，请稍后重试");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }

        // 从数据库查询个人收藏记录
        List<Favorite> userFavorites = favoriteService.getUserFavoritesByUserId(userId);
        if (userFavorites == null || userFavorites.size() == 0) {
            session.setAttribute("getFavoritesMsg", "个人收藏夹暂无数据，赶快收藏图书吧");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        req.setAttribute("userFavoritesList", userFavorites);
        req.getRequestDispatcher("/pages/book/favorite.jsp").forward(req, resp);
    }
}
