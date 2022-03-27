package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.pojo.Upload;
import com.bear.bookhouse.util.NumberUtil;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:31
 */
public class UploadDaoImpl extends BaseDao implements UploadDao {
    @Override
    public int saveUpload(Upload upload) {
        String sql = "INSERT INTO `t_upload` (`user_id`,`operation`,`score_change`,`time`,`title`) VALUES(?,?,?,?,?);";
        return update(sql, upload.getUserId(), upload.getOperation(), upload.getScoreChange(), upload.getTime(), upload.getTitle());

    }

    @Override
    public List<Upload> listUploadByUserId(int userId, int begin, int offset) {
        String sql = "SELECT `id`,`user_id` userId,`operation`,`score_change` scoreChange,`time`,`title` FROM `t_upload` WHERE `user_id` = ? ORDER BY `time` DESC LIMIT ?,?;";
        return listRecord(Upload.class, sql, userId, begin, offset);
    }

    @Override
    public int getUserUploadCounts(int userId) {
        String sql = "SELECT COUNT(`id`) FROM `t_upload` WHERE `user_id` = ?;";
        return NumberUtil.objectToInteger(getSingleValue(sql, userId), 0);
    }
}
