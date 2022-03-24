package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.RecordDao;
import com.bear.bookhouse.pojo.Record;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 10:01
 */
public class RecordDaoImpl extends BaseDao implements RecordDao {
    @Override
    public int saveOperationRecord(Record record) {
        String sql = "INSERT INTO `t_record` (`user_id`,`operation`,`score_change`,`time`,`title`) VALUES(?,?,?,?,?);";
        return update(sql, record.getUserId(), record.getOperation(), record.getScoreChange(), record.getTime(), record.getTitle());
    }

    @Override
    public List<Record> queryRecordByUserId(int userId) {
        String sql = "SELECT `id`,`user_id` userId,`operation`,`score_change` scoreChange,`time`,`title` FROM `t_record` WHERE `user_id` = ?;";
        return listRecord(Record.class, sql, userId);
    }
}
