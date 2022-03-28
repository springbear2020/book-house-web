package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.util.NumberUtil;

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
    public List<Download> listDownloadThoughUserIdByBeginAndOffset(int userId, int begin, int offset) {
        String sql = "SELECT `id`,`user_id` userId,`operation`,`score_change` scoreChange,`time`,`title` FROM `t_download` WHERE `user_id` = ? ORDER BY `time` DESC LIMIT ?,?;";
        return listRecord(Download.class, sql, userId, begin, offset);
    }

    @Override
    public int getDownloadCountsByUserId(int userId) {
        String sql = "SELECT COUNT(`id`) FROM `t_download` WHERE `user_id` = ?;";
        return NumberUtil.objectToInteger(getSingleValue(sql, userId), Download.ERROR);
    }
}
