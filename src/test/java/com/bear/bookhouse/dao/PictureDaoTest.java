package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.PictureDao;
import com.bear.bookhouse.dao.impl.PictureDaoImpl;
import com.bear.bookhouse.pojo.Picture;
import org.junit.Test;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:17
 */
public class PictureDaoTest {
    private final PictureDao pictureDao = new PictureDaoImpl();

    @Test
    public void getPictureById() {
        Picture picture = pictureDao.getPictureById(2);
        System.out.println(picture);
    }

    @Test
    public void getAllPicturesCount() {
        System.out.println(pictureDao.getAllPicturesCount());
    }
}