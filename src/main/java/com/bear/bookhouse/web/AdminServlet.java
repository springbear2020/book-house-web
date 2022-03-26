package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.service.PixabayService;
import com.bear.bookhouse.service.impl.PixabayServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:50
 */
public class AdminServlet extends BaseServlet {
    private final PixabayService pixabayService = new PixabayServiceImpl();

    /**
     * 随机获取一张 Pixabay 图片链接
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
}
