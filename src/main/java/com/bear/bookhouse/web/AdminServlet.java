package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.*;
import com.bear.bookhouse.service.PixabayService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.PixabayServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:50
 */
public class AdminServlet extends BaseServlet {
    private final PixabayService pixabayService = new PixabayServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

    /**
     * 管理员登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Admin admin = userService.getAdminByUsernameAndPassword(req.getParameter("username"), req.getParameter("password"));
        if (admin != null) {
            session.setAttribute("admin", admin);
        } else {
            session.setAttribute("noticeMsg", "用户名不存在或密码错误");
        }
        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
    }

    /**
     * 管理员注销登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().removeAttribute("admin");
        req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
    }

    /**
     * 获取一张 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showPixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("pixabay", pixabayService.showFirstPixabay());
        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
    }

    /**
     * 删除 Pixabay 图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deletePixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (pixabayService.deletePixabayById(NumberUtil.objectToInteger(req.getParameter("id"), Pixabay.ERROR))) {
            req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
        }
    }

    /**
     * 获取一条未处理的上传记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void obtainBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("upload", recordService.getFirstNotProcessedUpload(Upload.NOT_PROCESSED));
        req.getRequestDispatcher("/pages/admin/manage.jsp").forward(req, resp);
    }
}
