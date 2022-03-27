package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Admin;
import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.service.AdminService;
import com.bear.bookhouse.service.PixabayService;
import com.bear.bookhouse.service.impl.AdminServiceImpl;
import com.bear.bookhouse.service.impl.PixabayServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:50
 */
public class AdminServlet extends BaseServlet {
    private final PixabayService pixabayService = new PixabayServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    /**
     * 管理员注销
     *
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("admin");
        resp.sendRedirect(req.getContextPath() + "/pages/admin/admin.jsp");
    }

    /**
     * 管理员登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
        if (admin != null) {
            req.getSession().setAttribute("admin", admin);
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/404.html");
        }
    }

    /**
     * 随机获取一张 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void showPixabayRandomly(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Pixabay pixabay = pixabayService.getPixabayRandomly();
        req.setAttribute("pixabay", pixabay);
        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
    }

    /**
     * 删除图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deletePixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = NumberUtil.objectToInteger(req.getParameter("id"), -1);
        if (pixabayService.deletePixabayById(id)) {
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
