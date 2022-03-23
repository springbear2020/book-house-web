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

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:18
 */
public class FavoriteServlet extends BaseServlet {
    private final FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 添加收藏记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void addFavoriteRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        int bookId = NumberUtil.objectToInteger(req.getParameter("bookId"), -1);
        HttpSession session = req.getSession();
        if (userId == -1 || bookId == -1) {
            session.setAttribute("addFavoriteMsg", "图书加入收藏夹失败，请稍后重试");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        if (favoriteService.addFavorite(new Favorite(null, userId, bookId, new Date()))) {
            session.setAttribute("addFavoriteMsg", "图书加入收藏夹成功");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }
}
