package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.UploadDaoImpl;
import com.bear.bookhouse.pojo.Upload;
import org.junit.Test;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:44
 */
public class UploadDaoTest {
    private final UploadDao uploadDao = new UploadDaoImpl();

    @Test
    public void saveUpload() {
        System.out.println(uploadDao.saveUpload(new Upload(null, 2, "bear", "上传图书", "+10", new Date(), "浪潮之巅", "d:", "d:", "已处理")));
    }

    @Test
    public void listUploadByUserId() {
        System.out.println(uploadDao.listUploadByUserId(2, 1, 1));
    }

    @Test
    public void listUploadForAdmin() {
        System.out.println(uploadDao.listUploadByState("未处理"));
    }

    @Test
    public void updateState() {
        System.out.println(uploadDao.updateUploadState(2, "已处理"));
    }
}