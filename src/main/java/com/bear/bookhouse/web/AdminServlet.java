package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Admin;
import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.AdminService;
import com.bear.bookhouse.service.PixabayService;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.impl.AdminServiceImpl;
import com.bear.bookhouse.service.impl.PixabayServiceImpl;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import com.bear.bookhouse.util.NumberUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:50
 */
public class AdminServlet extends BaseServlet {
    private final PixabayService pixabayService = new PixabayServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

    /**
     * 删除磁盘 book 和 cover 文件
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deleteBookAndCover(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext servletContext = getServletContext();
        String bookPath = servletContext.getRealPath("/" + req.getParameter("bookPath"));
        String coverPath = servletContext.getRealPath("/" + req.getParameter("coverPath"));
        int id = NumberUtil.objectToInteger(req.getParameter("uploadId"), -1);
        File bookFile = new File(bookPath);
        File coverFile = new File(coverPath);
        if (bookFile.exists() && bookFile.isFile() && coverFile.exists() && coverFile.isFile()) {
            bookFile.delete();
            coverFile.delete();
            // 修改对应上传记录为已处理
            recordService.updateUploadState(id);
            resp.sendRedirect(req.getContextPath() + "/pages/admin/manage.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/500.html");
        }
    }

    /**
     * 获取未处理图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void obtainBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Upload> waitProcessBookList = recordService.listUploadForAdmin();
        req.setAttribute("waitProcessBookList", waitProcessBookList);
        req.getRequestDispatcher("/pages/admin/manage.jsp").forward(req, resp);
    }

    /**
     * 管理员注销
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("admin");
        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=showPixabayRandomly");
    }

    /**
     * 管理员登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
        if (admin != null) {
            req.getSession().setAttribute("admin", admin);
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/pages/error/404.html");
        }
    }

    /**
     * 随机获取一张 Pixabay 图片
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void showPixabayRandomly(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Pixabay pixabay = pixabayService.getPixabayRandomly();
        req.setAttribute("pixabay", pixabay);
        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
    }

    /**
     * 删除图书
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void deletePixabay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = NumberUtil.objectToInteger(req.getParameter("id"), -1);
        if (pixabayService.deletePixabayById(id)) {
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
