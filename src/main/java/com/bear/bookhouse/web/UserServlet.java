package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.EmailUtil;
import com.bear.bookhouse.util.WebUtil;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/14 17:25
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();
    private String verifyCodeBySystem;

    /**
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.queryUserByUsernameAndPassword(username, password) != null) {
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("loginErrorMsg", "用户名或密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    /**
     * 用户注册
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将注册表单中的各参数封装成 User
        User user = WebUtil.copyParamsToBean(new User(), req.getParameterMap());
        // 获取客户端输入的图片验证码
        String imgVerifyCode = req.getParameter("imgVerifyCode");
        // 获取由系统生成的图片验证码
        HttpSession session = req.getSession();
        Object imgVerifyCodeByGoogle = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 获取客户端输入的邮箱验证码
        String emailVerifyCode = req.getParameter("emailVerifyCode");

        System.out.println(this.verifyCodeBySystem);
        if (!this.verifyCodeBySystem.equalsIgnoreCase(emailVerifyCode)) {
            req.setAttribute("registerErrorMsg", "邮箱验证码有误");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        if (!imgVerifyCodeByGoogle.equals(imgVerifyCode)) {
            req.setAttribute("registerErrorMsg", "图片验证码有误");
            req.setAttribute("user", user);
            req.setAttribute("emailCode", emailVerifyCode);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 保存用户注册信息到数据库
        user.setRegisterDate(new Date());
        user.setScore(100);
        if (userService.saveUser(user)) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    /**
     * AJAX 请求验证用户名是否存在
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxVerifyUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        User user = userService.queryUserByUsername(username);
        if (user != null) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    /**
     * AJAX 请求发送随机验证码到指定邮箱
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxSendEmailCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        EmailUtil instance = EmailUtil.getInstance();
        try {
            instance.sendEmail(email);
            this.verifyCodeBySystem = instance.getVerifyCode();
            resp.getWriter().write("true");
        } catch (Exception e) {
            resp.getWriter().write("false");
            e.printStackTrace();
        }
    }
}
