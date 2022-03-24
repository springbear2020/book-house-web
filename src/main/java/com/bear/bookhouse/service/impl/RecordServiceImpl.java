package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.RecordDao;
import com.bear.bookhouse.dao.impl.RecordDaoImpl;
import com.bear.bookhouse.pojo.Record;
import com.bear.bookhouse.service.RecordService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 10:09
 */
public class RecordServiceImpl implements RecordService {
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public boolean addOperationRecord(Record record) {
        return recordDao.saveOperationRecord(record) == 1;
    }

    @Override
    public List<Record> getRecordByUserId(int userId) {
        return recordDao.queryRecordByUserId(userId);
    }
}
