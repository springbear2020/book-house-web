package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.pojo.UserInfo;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserInfoService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserInfoServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.DataUtil;
import com.bear.bookhouse.util.NumberUtil;
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
    private final UserInfoService userInfoService = new UserInfoServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

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
            req.setAttribute("noticeMsg", "邮箱验证码有误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }
        if (!imgVerifyCodeByGoogle.equals(imgVerifyCode)) {
            req.setAttribute("user", user);
            req.setAttribute("emailCode", emailVerifyCode);
            req.setAttribute("noticeMsg", "图片验证码有误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 用户注册默认积分 100，保存用户信息到数据库
        user.setScore(DataUtil.getRegisterScore());
        user.setRegisterDate(new Date());
        if (userService.saveUser(user)) {
            req.setAttribute("noticeMsg", "恭喜您注册成功！");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
        }
    }

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
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usernameOrEmail = req.getParameter("usernameOrEmail");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user;
        if (userService.isUsernameAndPasswordCorrect(usernameOrEmail, password) || userService.isEmailAndPasswordCorrect(usernameOrEmail, password)) {
            // 通过用户名或邮箱查询用户信息
            if ((user = userService.getUserByEmail(usernameOrEmail)) == null) {
                user = userService.getUserByUsername(usernameOrEmail);
            }
            // 用户名密码正确，保存用户登录日志、跳转到主页
            session.setAttribute("user", user);
            String ip = WebUtil.getIpAddress(req);
            String location = WebUtil.parseIp(ip) == null ? "未知" : WebUtil.parseIp(ip);
            if (recordService.saveLoginLog(new LoginLog(null, user.getId(), user.getUsername(), ip, location, new Date()))) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
            }
        } else {
            session.setAttribute("loginMsg", "用户名不存在或密码错误");
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        }
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
            req.setAttribute("noticeMsg", "邮箱验证码错误");
            req.getRequestDispatcher("/pages/user/pwdFind.jsp").forward(req, resp);
            return;
        }
        if (userService.updateUserPasswordByEmail(password, email)) {
            req.setAttribute("noticeMsg", "密码重置成功!");
            req.getRequestDispatcher("/pages/user/pwdFind.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.jsp");
        }
    }

    /**
     * 显示用户个人信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showPersonal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        // 从域中获取的用户 id 确保了 id 不会非法
        int userId = NumberUtil.objectToInteger(user.getId(), -1);
        UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
        req.setAttribute("userInfo", userInfo);
        req.getRequestDispatcher("/pages/user/personal.jsp").forward(req, resp);
    }
}
