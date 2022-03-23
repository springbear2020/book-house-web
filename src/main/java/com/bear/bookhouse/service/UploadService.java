package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:07
 */
public interface UploadService {
    /**
     * 添加用户图书上传记录
     *
     * @param upload Upload
     * @return true - 添加成功
     */
    boolean addBookUploadRecord(Upload upload);

    /**
     * 查询用户上传记录
     *
     * @param userId 用户 id
     * @return 上传记录
     */
    List<Upload> getUploadRecord(int userId);
}
