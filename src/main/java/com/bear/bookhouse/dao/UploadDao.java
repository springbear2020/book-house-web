package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:04
 */
public interface UploadDao {
    /**
     * 保存用户图书上传记录
     *
     * @param upload Upload
     * @return 1 - 保存成功
     */
    int saveBookUploadRecord(Upload upload);

    /**
     * 通过用户 id 查询下载记录
     *
     * @param userId 用户 id
     * @return 下载记录
     */
    List<Upload> queryUploadRecordByUserId(int userId);
}
