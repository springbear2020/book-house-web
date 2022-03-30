package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Background;
import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.service.PictureService;
import com.bear.bookhouse.service.impl.PictureServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/29 17:11
 */
public class PictureServlet extends BaseServlet {
    private final PictureService pictureService = new PictureServiceImpl();

    /**
     * 获取一张 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showPixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("pixabay", pictureService.getPixabayRandomly());
        req.getRequestDispatcher("/WEB-INF/pages/admin/pixabay.jsp").forward(req, resp);
    }

    /**
     * 删除 Pixabay 图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deletePixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") == null) {
            session.setAttribute("noticeMsg", "Dear admin, please log in first");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        String type = req.getParameter("type");
        if (Pixabay.DELETE_ALL.equals(type)) {
            // 清空 t_pixabay 表并将 auto_increment 重置为 1
            if (pictureService.deleteAllPixabayAndReset()) {
                session.setAttribute("noticeMsg", "Delete all pixabay successfully");
                req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
                return;
            }
        } else if (Pixabay.DELETE_ONE.equals(type)) {
            // 根据 id 删除图片
            if (pictureService.deletePixabayById(NumberUtil.objectToInteger(req.getParameter("id"), Pixabay.ERROR))) {
                session.setAttribute("noticeMsg", "Delete one pixabay successfully");
                req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("/index.jsp");
    }

    /**
     * 显示一张背景图
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBackground(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Background background = pictureService.getBackgroundRandomly();
        req.setAttribute("background", background);
        req.getRequestDispatcher("/WEB-INF/pages/admin/admin.jsp").forward(req, resp);
    }
}
