package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Download;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:15
 */
public interface DownloadService {
    /**
     * 添加用户图书下载记录
     *
     * @param download Download
     * @return true - 添加成功
     */
    boolean addDownloadRecord(Download download);

    /**
     * 查询用户下载记录
     *
     * @param userId 用户 id
     * @return 下载记录
     */
    List<Download> getUserDownload(int userId);
}
