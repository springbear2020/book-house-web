package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Download;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:29
 */
public interface DownloadDao {
    /**
     * 保存用户图书下载记录
     *
     * @param download 下载记录
     * @return 1 - 保存成功
     */
    int saveDownload(Download download);

    /**
     * 通过用户 id 查询用户下载记录，
     * 并根据起始位置和偏移量指定所需页数据
     *
     * @param userId 用户 id
     * @param begin  起始位置
     * @param offset 偏移量
     * @return Download or null
     */
    List<Download> listDownloadThoughUserIdByBeginAndOffset(int userId, int begin, int offset);

    /**
     * 获取用户下载记录总数
     *
     * @param userId 用户 id
     * @return 下载记录总数
     */
    int getDownloadCountsByUserId(int userId);
}
