package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Record;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 10:07
 */
public interface RecordService {
    /**
     * 保存用户记录
     *
     * @param record 记录
     * @return true - 保存成功
     */
    boolean addRecord(Record record);

    /**
     * 通过用户 id 查询用户记录
     *
     * @param userId 用户 id
     * @return 操作记录
     */
    List<Record> getRecord(int userId);
}
