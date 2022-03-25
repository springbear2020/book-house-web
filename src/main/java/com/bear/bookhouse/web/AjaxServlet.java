package com.bear.bookhouse.web;

import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.EmailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 16:45
 */
public class AjaxServlet extends BaseServlet {
    /**
     * 用户注册时邮箱验证码
     */
    private static String registerEmailCode;
    /**
     * 用户找回密码时邮箱验证码
     */
    private static String passwordFindEmailCode;

    public static String getRegisterEmailCode() {
        return registerEmailCode;
    }

    public static String getPasswordFindEmailCode() {
        return passwordFindEmailCode;
    }

    private final UserService userService = new UserServiceImpl();

    /**
     * AJAX 请求验证用户名是否已使用
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxVerifyUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        if (userService.isUsernameExists(username)) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    /**
     * AJAX 请求验证邮箱地址是否已使用
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxVerifyEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        if (userService.isEmailExists(email)) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    /**
     * AJAX 找回密码请求发送随机验证码到指定邮箱
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxSendPasswordFindEmailCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        EmailUtil instance = EmailUtil.getInstance();
        try {
            instance.sendEmail(email);
            AjaxServlet.passwordFindEmailCode = instance.getVerifyCode();
            resp.getWriter().write("true");
        } catch (Exception e) {
            resp.getWriter().write("false");
            e.printStackTrace();
        }
    }

    /**
     * AJAX 注册请求发送随机验证码到指定邮箱
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxSendRegisterEmailCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        EmailUtil instance = EmailUtil.getInstance();
        try {
            instance.sendEmail(email);
            AjaxServlet.registerEmailCode = instance.getVerifyCode();
            resp.getWriter().write("true");
        } catch (Exception e) {
            resp.getWriter().write("false");
            e.printStackTrace();
        }
    }
}
