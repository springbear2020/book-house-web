package com.bear.bookhouse.web;

import com.bear.bookhouse.pojo.Record;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
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
    private final RecordService recordService = new RecordServiceImpl();

    /**
     * 显示图书记录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    protected void showRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int userId = NumberUtil.objectToInteger(req.getParameter("userId"), -1);
        HttpSession session = req.getSession();
        // 图书下载记录
        List<Record> recordList = recordService.getRecord(userId);
        if (recordList == null || recordList.size() == 0) {
            session.setAttribute("queryRecordMsg", "暂无记录，快去下载或上传图书吧");
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        req.setAttribute("recordList", recordList);
        req.getRequestDispatcher("/pages/book/record.jsp").forward(req, resp);
    }
}
