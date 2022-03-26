package com.bear.bookhouse.service.impl;


import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.dao.LoginLogDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.dao.impl.DownloadDaoImpl;
import com.bear.bookhouse.dao.impl.LoginLogDaoImpl;
import com.bear.bookhouse.dao.impl.UploadDaoImpl;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.LoginLog;
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
    public List<Download> listDownloadByUserId(int userId) {
        return downloadDao.listDownloadByUserId(userId);
    }

    @Override
    public boolean saveUpload(Upload upload) {
        return uploadDao.saveUpload(upload) == 1;
    }

    @Override
    public List<Upload> listUploadByUserId(int userId) {
        return uploadDao.listUploadByUserId(userId);
    }

    @Override
    public boolean saveLoginLog(LoginLog loginLog) {
        return loginLogDao.saveLoginLog(loginLog) == 1;
    }

    @Override
    public List<LoginLog> listLoginLogsByUserId(int userId) {
        return loginLogDao.listLoginLogsByUserId(userId);
    }
}
