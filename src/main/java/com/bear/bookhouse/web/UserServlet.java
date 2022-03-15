package com.bear.bookhouse.web;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/14 17:25
 */
public class UserServlet extends BaseServlet {
    /**
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp){
    }

    /**
     * 用户注册
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String emailVerifyCode = req.getParameter("emailVerifyCode");
        String imgVerifyCode = req.getParameter("imgVerifyCode");
        // 获取由谷歌生成的图片验证码
        HttpSession session = req.getSession();
        Object imgVerifyCodeByGoogle = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(emailVerifyCode);
        System.out.println(imgVerifyCode);
    }
}
