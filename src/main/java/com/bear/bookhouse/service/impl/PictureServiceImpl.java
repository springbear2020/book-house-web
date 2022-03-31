package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.BackgroundDao;
import com.bear.bookhouse.dao.PixabayDao;
import com.bear.bookhouse.dao.impl.BackgroundDaoImpl;
import com.bear.bookhouse.dao.impl.PixabayDaoImpl;
import com.bear.bookhouse.pojo.Background;
import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.service.PictureService;
import com.bear.bookhouse.util.NumberUtil;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:48
 */
public class PictureServiceImpl implements PictureService {
    private final PixabayDao pixabayDao = new PixabayDaoImpl();
    private final BackgroundDao backgroundDao = new BackgroundDaoImpl();

    @Override
    public Pixabay getPixabayRandomly() {
        return pixabayDao.getPixabayById(NumberUtil.generateOneNumberInBoundRandomly(pixabayDao.getPixabayCounts()));
    }

    @Override
    public boolean deletePixabayById(int id) {
        return pixabayDao.deletePixabayById(id) == 1;
    }

    @Override
    public boolean deleteAllPixabayAndReset() {
        int j = pixabayDao.deleteAllPixabay();
        // alter table table_name auto_increment 返回值为 0
        int i = pixabayDao.resetIncrement();
        return (i + j) >= 0;
    }

    @Override
    public boolean saveBackground(Background background) {
        return backgroundDao.saveBackground(background) == 1;
    }

    @Override
    public Background getBackgroundRandomly() {
        int backgroundCounts = backgroundDao.getBackgroundCounts();
        return backgroundDao.getBackgroundById(NumberUtil.generateOneNumberInBoundRandomly(backgroundCounts));
    }

    @Override
    public Pixabay getFirstPixabay() {
        return pixabayDao.getFirstPixabay();
    }
}
