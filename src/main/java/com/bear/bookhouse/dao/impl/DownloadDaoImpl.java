package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.pojo.Download;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:10
 */
public class DownloadDaoImpl extends BaseDao implements DownloadDao {
    @Override
    public int saveDownloadRecord(Download download) {
        String sql = "INSERT INTO `t_download`(`user_id`,`book_id`,`download_time`,`title`) VALUES (?,?,?,?);";
        return update(sql, download.getUserId(), download.getBookId(), download.getDownloadTime(), download.getTitle());
    }

    @Override
    public List<Download> queryDownloadRecordByUserId(int userId) {
        String sql = "SELECT `download_time` downloadTime, `title` FROM `t_download` WHERE `user_id` = ?;";
        return listRecord(Download.class, sql, userId);
    }
}
