package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.pojo.Download;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:31
 */
public class DownloadDaoImpl extends BaseDao implements DownloadDao {
    @Override
    public int saveDownload(Download download) {
        String sql = "INSERT INTO `t_download` (`user_id`,`operation`,`score_change`,`time`,`title`) VALUES(?,?,?,?,?);";
        return update(sql, download.getUserId(), download.getOperation(), download.getScoreChange(), download.getTime(), download.getTitle());
    }

    @Override
    public List<Download> listDownloadByUserId(int userId) {
        String sql = "SELECT `id`,`user_id` userId,`operation`,`score_change` scoreChange,`time`,`title` FROM `t_download` WHERE `user_id` = ?;";
        return listRecord(Download.class, sql, userId);
    }
}
