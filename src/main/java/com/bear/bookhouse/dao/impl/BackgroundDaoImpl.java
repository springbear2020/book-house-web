package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BackgroundDao;
import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.pojo.Background;
import com.bear.bookhouse.util.NumberUtil;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/29 15:28
 */
public class BackgroundDaoImpl extends BaseDao implements BackgroundDao {
    @Override
    public int saveBackground(Background background) {
        String sql = "INSERT INTO `t_background`(`sentence`,`path`,`upload_time`,`upload_user`) VALUES (?,?,?,?);";
        return update(sql, background.getSentence(), background.getPath(), background.getUploadTime(), background.getUploadUser());
    }

    @Override
    public Background getBackgroundById(int id) {
        String sql = "SELECT `id`,`sentence`,`path`,`upload_time` uploadTime,`upload_user` uploadUser FROM t_background WHERE `id` = ?;";
        return getRecord(Background.class, sql, id);
    }

    @Override
    public int getBackgroundCounts() {
        String sql = "SELECT COUNT(`id`) FROM `t_background`;";
        return NumberUtil.objectToInteger(getSingleValue(sql), Background.ERROR);
    }
}
