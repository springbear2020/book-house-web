package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Download;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:09
 */
public interface DownloadDao {
    /**
     * 保存用户下载记录
     *
     * @param download 下载记录
     * @return 1 - 保存成功
     */
    int saveDownloadRecord(Download download);

    /**
     * 通过用户 id 查询用户下载记录
     *
     * @param userId 用户 id
     * @return Download Record or null
     */
    List<Download> queryDownloadRecordByUserId(int userId);
}
