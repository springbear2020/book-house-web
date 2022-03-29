package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.*;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.PictureService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.service.impl.PictureServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:50
 */
public class AdminServlet extends BaseServlet {
    private final PictureService pictureService = new PictureServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    /**
     * 获取一张 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showPixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("pixabay", pictureService.getPixabayRandomly());
        req.getRequestDispatcher("/WEB-INF/pages/admin/pixabay.jsp").forward(req, resp);
    }

    /**
     * 删除 Pixabay 图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deletePixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") == null) {
            session.setAttribute("noticeMsg", "Dear admin, please log in first");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        String type = req.getParameter("type");
        if (Pixabay.DELETE_ONE.equals(type)) {
            // 清空 t_pixabay 表并将 auto_increment 重置为 1
            if (pictureService.deleteAllPixabayAndReset()) {
                session.setAttribute("noticeMsg", "Delete all pixabay successfully");
                req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
                return;
            }
        } else if (Pixabay.DELETE_ALL.equals(type)) {
            // 根据 id 删除图片
            if (pictureService.deletePixabayById(NumberUtil.objectToInteger(req.getParameter("id"), Pixabay.ERROR))) {
                session.setAttribute("noticeMsg", "Delete one pixabay successfully");
                req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("/index.jsp");
    }

    /**
     * 管理员登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        // 管理员已登录直接转发到管理员界面
        if (session.getAttribute("admin") != null) {
            req.getRequestDispatcher("/WEB-INF/pages/admin/admin.jsp").forward(req, resp);
            return;
        }
        // 验证管理员账户密码
        Admin admin = userService.getAdminByUsernameAndPassword(req.getParameter("username"), req.getParameter("password"));
        if (admin != null) {
            session.setAttribute("admin", admin);
            req.getRequestDispatcher("admin?action=showBackground").forward(req, resp);
        } else {
            session.setAttribute("noticeMsg", "The administrator does not exist or the password is wrong");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 管理员注销登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void adminLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().removeAttribute("admin");
        req.getRequestDispatcher("/admin?action=showPixabay").forward(req, resp);
    }

    /**
     * 处理一条用户的图书上传记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void processUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), User.ERROR);
        int uploadId = NumberUtil.objectToInteger(req.getParameter("uploadId"), Upload.ERROR);
        String bookPath = req.getParameter("bookPath");
        String coverPath = req.getParameter("coverPath");
        Book book = (Book) req.getAttribute("bookByAdmin");
        HttpSession session = req.getSession();
        // 保存图书记录到数据库、删除磁盘用户上传的文件、增加用户积分、修改上传记录状态为已处理
        File bookFile = new File(getServletContext().getRealPath("/" + bookPath));
        File coverFile = new File(getServletContext().getRealPath("/" + coverPath));
        // 删除磁盘文件
        if (bookFile.exists() && coverFile.exists() && bookFile.delete() && coverFile.delete()) {
            // 保存图书、修改上传记录状态为已处理、增加用户积分
            if (bookService.saveBook(book) && recordService.updateUploadState(uploadId) && userService.addUserScore(User.SCORE_CHANGE, userId)) {
                session.setAttribute("noticeMsg", "Save book, delete files, update state, issue points successfully");
            }
        } else {
            session.setAttribute("noticeMsg", "Delete the book or the cover file failed");
        }
        req.getRequestDispatcher("/WEB-INF/pages/admin/book.jsp").forward(req, resp);
    }

    /**
     * 显示一张背景图
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showBackground(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Background background = pictureService.getBackgroundRandomly();
        req.setAttribute("background", background);
        req.getRequestDispatcher("/WEB-INF/pages/admin/admin.jsp").forward(req, resp);
    }
}