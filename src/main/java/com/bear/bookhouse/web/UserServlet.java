package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.WebUtil;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/14 17:25
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    /**
     * 注销登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    /**
     * 修改用户密码
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String emailVerifyCode = req.getParameter("emailVerifyCode");
        String password = req.getParameter("password");

        // 用户输入的邮箱验证码错误，返回修改界面
        if (!emailVerifyCode.equalsIgnoreCase(AjaxServlet.getPasswordFindEmailCode())) {
            req.setAttribute("updatePwdErrorMsg", "邮箱验证码错误");
            req.getRequestDispatcher("/pages/user/pwdFind.jsp").forward(req, resp);
            return;
        }
        if (userService.updateUserPasswordByEmail(password, email)) {
            req.setAttribute("updatePwdSuccessMsg", "密码重置成功!");
            req.getRequestDispatcher("/pages/user/pwdFind.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
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

        if (userService.isUsernameAndPasswordCorrect(username, password)) {
            // 用户名密码正确，跳转到主页
            req.getSession().setAttribute("user", userService.getUserByUsername(username));
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("loginMsg", "用户名不存在或密码错误");
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
        Object imgVerifyCodeByGoogle = req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 获取客户端输入的邮箱验证码
        String emailVerifyCode = req.getParameter("emailVerifyCode");

        if (!emailVerifyCode.equalsIgnoreCase(AjaxServlet.getRegisterEmailCode())) {
            req.setAttribute("user", user);
            req.setAttribute("registerErrorMsg", "邮箱验证码有误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }
        if (!imgVerifyCodeByGoogle.equals(imgVerifyCode)) {
            req.setAttribute("user", user);
            req.setAttribute("registerErrorMsg", "图片验证码有误");
            req.setAttribute("emailCode", emailVerifyCode);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 保存用户注册信息到数据库
        user.setRegisterDate(new Date());
        user.setScore(100);
        if (userService.saveUser(user)) {
            req.setAttribute("registerSuccessMsg", "恭喜您注册成功！");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
        }
    }
}
