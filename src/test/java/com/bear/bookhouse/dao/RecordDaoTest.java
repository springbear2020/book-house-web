package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.RecordDaoImpl;
import com.bear.bookhouse.pojo.Record;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 10:03
 */
public class RecordDaoTest {
    private final RecordDao recordDao = new RecordDaoImpl();

    @Test
    public void saveOperationRecord() {
        System.out.println(recordDao.saveRecord(new Record(null, 2, "上传图书", "+10", new Date(), "浪潮之巅")));
    }

    @Test
    public void queryRecordByUserId() {
        List<Record> records = recordDao.listRecordByUserId(2);
        for (Record record : records) {
            System.out.println(record);
        }
    }
}