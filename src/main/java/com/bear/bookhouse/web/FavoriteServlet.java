package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.FavoriteService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.FavoriteServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
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
    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 添加收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 客户端 favoriteServlet?action=addFavorite&bookId=${book.id}&userId=${sessionScope.user.id}&title=${book.title} 确保了 id 不会越界
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String coverPath = req.getParameter("coverPath");
        HttpSession session = req.getSession();

        // 查询用户图书收藏记录是否已经存在
        if (favoriteService.isFavoriteExists(userId, bookId)) {
            session.setAttribute("addFavoriteMsg", "图书收藏记录已存在，不可重复收藏");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        // 保存收藏记录
        // TODO 事务机制确保数据一致性，触发器完成对应数据的增减
        if (favoriteService.addFavorite(new Favorite(null, userId, bookId, title, author, coverPath, new Date()))) {
            // 图书收藏量增加 1
            if (bookService.addBookFavorites(1, bookId)) {
                session.setAttribute("addFavoriteMsg", "图书加入收藏夹成功");
            } else {
                session.setAttribute("addFavoriteMsg", "图书加入收藏夹失败，请稍后重试");
            }
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 删除收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deleteFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 客户端请求：favoriteServlet?action=deleteFavorite&userId=${sessionScope.user.id}&bookId=${favorite.bookId} 确保 id 不会越界
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        HttpSession session = req.getSession();

        // TODO 事务机制确保数据一致性，触发器完成对应数据的增减
        if (!favoriteService.deleteFavorite(userId, bookId)) {
            session.setAttribute("deleteFavoritesMsg", "图书取消收藏失败，请稍后重试");
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
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("showFavoritesMsg", "用户 id 不合法");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        // 从数据库查询用户个人收藏记录
        List<Favorite> userFavorites = favoriteService.getFavorites(userId);
        if (userFavorites == null || userFavorites.size() == 0) {
            session.setAttribute("showFavoritesMsg", "个人收藏夹暂无数据，赶快收藏图书吧");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("userFavoritesList", userFavorites);
            req.getRequestDispatcher("/pages/book/favorite.jsp").forward(req, resp);
        }
    }
}
