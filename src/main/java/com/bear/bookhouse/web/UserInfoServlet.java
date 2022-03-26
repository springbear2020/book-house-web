package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.pojo.UserInfo;
import com.bear.bookhouse.service.UserInfoService;
import com.bear.bookhouse.service.impl.UserInfoServiceImpl;
import com.bear.bookhouse.util.DateUtil;
import com.bear.bookhouse.util.NumberUtil;
import com.bear.bookhouse.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 16:39
 */
public class UserInfoServlet extends BaseServlet {
    private final UserInfoService userInfoService = new UserInfoServiceImpl();

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

    /**
     * 保存用户个人信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void saveUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String nickname = req.getParameter("nickname");
        String sex = req.getParameter("sex");
        String birth = req.getParameter("birth");
        String location = req.getParameter("location");
        String signature = req.getParameter("signature");
        UserInfo userInfo = new UserInfo(null, NumberUtil.objectToInteger(userId, -1), nickname, sex, DateUtil.stringFormatDate(birth), location, signature, new Date());
        if (userInfoService.updateUserInfo(userInfo)) {
            session.setAttribute("noticeMsg", "个人信息修改成功");
        } else {
            session.setAttribute("noticeMsg", "个人信息修改失败，请稍后重试");
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
