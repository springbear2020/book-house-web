package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.service.UploadService;
import org.junit.Test;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:09
 */
public class UploadServiceImplTest {
    private final UploadService uploadService = new UploadServiceImpl();

    @Test
    public void addBookUploadRecord() {
        System.out.println(uploadService.addBookUploadRecord(new Upload(null,  1, new Date(), "bear", "bear", "bear")));
    }
}