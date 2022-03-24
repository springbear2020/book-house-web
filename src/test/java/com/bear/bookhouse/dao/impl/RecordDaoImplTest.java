package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.RecordDao;
import com.bear.bookhouse.pojo.Record;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 10:03
 */
public class RecordDaoImplTest {
    private final RecordDao recordDao = new RecordDaoImpl();

    @Test
    public void saveOperationRecord() {
        System.out.println(recordDao.saveRecord(new Record(null, 2, "上传图书", "+10", new Date(), "浪潮之巅")));
    }

    @Test
    public void queryRecordByUserId() {
        List<Record> records = recordDao.getRecordByUserId(2);
        for (Record record : records) {
            System.out.println(record);
        }
    }
}