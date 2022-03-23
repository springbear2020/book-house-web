package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.dao.impl.DownloadDaoImpl;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.service.DownloadService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:15
 */
public class DownloadServiceImpl implements DownloadService {
    private final DownloadDao downloadDao = new DownloadDaoImpl();

    @Override
    public boolean addDownloadRecord(Download download) {
        return downloadDao.saveDownloadRecord(download) == 1;
    }

    @Override
    public List<Download> getUserDownload(int userId) {
        return downloadDao.queryDownloadRecordByUserId(userId);
    }
}
