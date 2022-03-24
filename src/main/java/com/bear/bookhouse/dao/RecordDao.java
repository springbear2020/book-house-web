package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Record;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 9:59
 */
public interface RecordDao {
    /**
     * 保存操作记录
     *
     * @param record 记录
     * @return 1 - 保存成功
     */
    int saveOperationRecord(Record record);

    /**
     * 通过用户 id 查询用户操作记录
     *
     * @param userId 用户 id
     * @return Record or null
     */
    List<Record> queryRecordByUserId(int userId);
}
