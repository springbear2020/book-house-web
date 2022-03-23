package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.pojo.Download;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:13
 */
public class DownloadDaoImplTest {
    private final DownloadDao downloadDao = new DownloadDaoImpl();

    @Test
    public void saveDownloadRecord() {
        System.out.println(downloadDao.saveDownloadRecord(new Download(null, 1, 1, new Date(), "浪潮之巅")));
    }

    @Test
    public void queryDownloadRecordByUserId() {
        List<Download> downloads = downloadDao.queryDownloadRecordByUserId(1);
        for (Download download : downloads) {
            System.out.println(download);
        }
    }
}