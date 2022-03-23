package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.dao.impl.UploadDaoImpl;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.UploadService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:08
 */
public class UploadServiceImpl implements UploadService {
    private final UploadDao uploadDao = new UploadDaoImpl();

    @Override
    public boolean addBookUploadRecord(Upload upload) {
        return uploadDao.saveBookUploadRecord(upload) == 1;
    }

    @Override
    public List<Upload> getUploadRecord(int userId) {
        return uploadDao.queryUploadRecordByUserId(userId);
    }
}
