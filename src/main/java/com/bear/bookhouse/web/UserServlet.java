package com.bear.bookhouse.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/14 17:25
 */
public class UserServlet extends HttpServlet {
    /**
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * 用户注册
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
