package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
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

    /**
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("已收到用户登录请求，处理中~~~");
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
        // 获取客户端输入的邮箱验证码和图片验证码
        String emailVerifyCode = req.getParameter("emailVerifyCode");
        String imgVerifyCode = req.getParameter("imgVerifyCode");
        // 获取由谷歌生成的图片验证码和系统发送给用户的邮箱验证码
        HttpSession session = req.getSession();
        Object imgVerifyCodeByGoogle = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String emailVerifyCodeBySystem = "bear";

        if (!emailVerifyCodeBySystem.equals(emailVerifyCode)) {
            req.setAttribute("emailErrorMsg", "邮箱验证码有误，请检查后重新输入");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }
        if (!imgVerifyCodeByGoogle.equals(imgVerifyCode)) {
            req.setAttribute("imgErrorMsg", "图片验证码有误，请检查后重新输入");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 保存用户注册信息到数据库
        user.setRegisterDate(new Date());
        if (userService.saveUser(user)) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    /**
     * AJAX 请求获取邮箱验证码
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxGetVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        System.out.println(email);
        resp.getWriter().write("验证码已成功发送到您的邮箱，请注意查收哦！");
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
            resp.getWriter().write("用户名已存在，请重新输入");
        } else {
            resp.getWriter().write("用户名可用");
        }
    }
}
