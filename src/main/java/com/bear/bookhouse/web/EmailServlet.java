package com.bear.bookhouse.web;

import com.bear.bookhouse.util.EmailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/19 21:28
 */
public class EmailServlet extends BaseServlet {

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
            UserServlet.setRegisterEmailCode(instance.getVerifyCode());
            resp.getWriter().write("true");
        } catch (Exception e) {
            resp.getWriter().write("false");
            e.printStackTrace();
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
            UserServlet.setPasswordFindEmailCode(instance.getVerifyCode());
            resp.getWriter().write("true");
        } catch (Exception e) {
            resp.getWriter().write("false");
            e.printStackTrace();
        }
    }
}
