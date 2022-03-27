package com.bear.bookhouse.service.impl;


import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.dao.LoginLogDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.dao.impl.DownloadDaoImpl;
import com.bear.bookhouse.dao.impl.LoginLogDaoImpl;
import com.bear.bookhouse.dao.impl.UploadDaoImpl;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.RecordService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:49
 */
public class RecordServiceImpl implements RecordService {
    private final DownloadDao downloadDao = new DownloadDaoImpl();
    private final UploadDao uploadDao = new UploadDaoImpl();
    private final LoginLogDao loginLogDao = new LoginLogDaoImpl();

    @Override
    public boolean saveDownload(Download download) {
        return downloadDao.saveDownload(download) == 1;
    }

    @Override
    public Page<Download> listDownloadPageData(int userId, int pageNum, int pageSize) {
        Page<Download> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户下载登录总记录数
        int downloadCounts = downloadDao.getDownloadCounts(userId);
        if (downloadCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = downloadCounts / pageSize;
        if (downloadCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(downloadCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户登录数据
        page.setPageData(downloadDao.listDownloadByUserId(userId, pageNum, pageSize));
        return page;
    }

    @Override
    public boolean saveUpload(Upload upload) {
        return uploadDao.saveUpload(upload) == 1;
    }

    @Override
    public Page<Upload> listUploadPageData(int userId, int pageNum, int pageSize) {
        Page<Upload> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户上传登录总记录数
        int userUploadCounts = uploadDao.getUserUploadCounts(userId);
        if (userUploadCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = userUploadCounts / pageSize;
        if (userUploadCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(userUploadCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户登录数据
        page.setPageData(uploadDao.listUploadByUserId(userId, pageNum, pageSize));
        return page;
    }

    @Override
    public boolean saveLoginLog(LoginLog loginLog) {
        return loginLogDao.saveLoginLog(loginLog) == 1;
    }

    @Override
    public Page<LoginLog> listLoginLogPageData(int userId, int pageNum, int pageSize) {
        Page<LoginLog> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户登录总记录数
        int userLoginLogCounts = loginLogDao.getUserLoginLogCounts(userId);
        if (userLoginLogCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = userLoginLogCounts / pageSize;
        if (userLoginLogCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(userLoginLogCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户登录数据
        page.setPageData(loginLogDao.listLoginLogsByUserId(userId, pageNum, pageSize));
        return page;
    }
}
