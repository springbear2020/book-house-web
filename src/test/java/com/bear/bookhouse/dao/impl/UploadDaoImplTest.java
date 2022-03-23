package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.pojo.Upload;
import org.junit.Test;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:44
 */
public class UploadDaoImplTest {
    private final UploadDao uploadDao = new UploadDaoImpl();

    @Test
    public void queryUploadRecordByUserId() {
        List<Upload> uploads = uploadDao.queryUploadRecordByUserId(1);
        for (Upload upload : uploads) {
            System.out.println(upload);
        }
    }
}