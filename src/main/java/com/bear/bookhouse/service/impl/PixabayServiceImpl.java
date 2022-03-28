package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.PixabayDao;
import com.bear.bookhouse.dao.impl.PixabayDaoImpl;
import com.bear.bookhouse.pojo.Pixabay;
import com.bear.bookhouse.service.PixabayService;
import com.bear.bookhouse.util.NumberUtil;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:48
 */
public class PixabayServiceImpl implements PixabayService {
    private final PixabayDao pixabayDao = new PixabayDaoImpl();

    @Override
    public Pixabay getPixabayRandomly() {
        return pixabayDao.getPixabayById(NumberUtil.generateOneNumberInBoundRandomly(pixabayDao.getPixabayCounts()));
    }

    @Override
    public int getPixabayCounts() {
        return pixabayDao.getPixabayCounts();
    }

    @Override
    public boolean deletePixabayById(int id) {
        return pixabayDao.deletePixabayById(id) == 1;
    }

    @Override
    public Pixabay showFirstPixabay() {
        return pixabayDao.getFirstPixabay();
    }
}
