package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.PictureDao;
import com.bear.bookhouse.dao.impl.PictureDaoImpl;
import com.bear.bookhouse.pojo.Picture;
import com.bear.bookhouse.service.PictureService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:31
 */
public class PictureServiceImpl implements PictureService {
    private final PictureDao pictureDao = new PictureDaoImpl();

    @Override
    public List<String> getPicturesUrlById(Integer[] id) {
        List<String> urlList = new ArrayList<>();
        for (Integer o : id) {
            Picture picture = pictureDao.getPictureById(o);
            urlList.add(picture.getUrl());
        }
        return urlList;
    }
}
