package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.pojo.Record;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 15:47
 */
public class RecordServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

    /**
     * 显示用户上传记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 id 不合法");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        // 查询用户个人图书上传记录
        List<Upload> recordList = recordService.listUploadByUserId(userId);
        if (recordList == null || recordList.size() == 0) {
            session.setAttribute("noticeMsg", "暂无上传记录，快去上传图书吧");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        req.setAttribute("recordList", recordList);
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }

    /**
     * 显示用户下载记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showDownload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 id 不合法");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        // 查询用户个人图书下载记录
        List<Download> recordList = recordService.listDownloadByUserId(userId);
        if (recordList == null || recordList.size() == 0) {
            session.setAttribute("noticeMsg", "暂无下载记录，快去下载图书吧");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        req.setAttribute("recordList", recordList);
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }

    /**
     * 显示用户下载记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showLoginLog(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        // 验证用户 id 是否合法
        if (userId <= 0 || userService.isUserIdExists(userId)) {
            session.setAttribute("noticeMsg", "用户 id 不合法");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        // 查询用户个人登录记录
        List<LoginLog> loginList = recordService.listLoginLogsByUserId(userId);
        req.setAttribute("loginList", loginList);
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }
}
