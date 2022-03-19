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
    private static String registerEmailCode;
    private static String passwordFindEmailCode;

    public static void setRegisterEmailCode(String registerEmailCode) {
        UserServlet.registerEmailCode = registerEmailCode;
    }

    public static void setPasswordFindEmailCode(String passwordFindEmailCode) {
        UserServlet.passwordFindEmailCode = passwordFindEmailCode;
    }

    /**
     * 修改用户密码
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void updateUserPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String emailVerifyCode = req.getParameter("emailVerifyCode");
        String password = req.getParameter("password");
        // 用户输入的邮箱验证码错误，返回修改界面
        if (!UserServlet.passwordFindEmailCode.equalsIgnoreCase(emailVerifyCode)) {
            req.setAttribute("updatePwdErrorMsg", "邮箱验证码错误");
            req.getRequestDispatcher("/pages/user/pwdFind.jsp").forward(req, resp);
            return;
        }

        // TODO 解决密码更新失败 bug
        if (userService.updateUserPasswordByEmail(email, password)) {
            resp.getWriter().write("密码修改成功");
            resp.sendRedirect("/pages/user/login.jsp");
        }
    }

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

        if (!registerEmailCode.equalsIgnoreCase(emailVerifyCode)) {
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
            resp.sendRedirect(("/pages/user/login.jsp"));
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
     * AJAX 请求验证邮箱地址存在性
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void ajaxVerifyEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        if (userService.queryUserByEmail(email) != null) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }
}
