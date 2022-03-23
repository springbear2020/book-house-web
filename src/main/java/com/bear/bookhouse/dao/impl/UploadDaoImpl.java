package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:05
 */
public class UploadDaoImpl extends BaseDao implements UploadDao {
    @Override
    public int saveBookUploadRecord(Upload upload) {
        String sql = "INSERT INTO `t_upload`(`user_id`, `upload_time`,`title`,`book_path`,`cover_path`) VALUES (?,?,?,?,?);";
        return update(sql, upload.getUserId(), upload.getUploadTime(), upload.getTitle(), upload.getBookPath(), upload.getCoverPath());
    }

    @Override
    public List<Upload> queryUploadRecordByUserId(int userId) {
        String sql = "SELECT `upload_time` uploadTime, `title` FROM `t_upload` WHERE `user_id` = ?;";
        return listRecord(Upload.class, sql, userId);
    }
}
