package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.PictureDao;
import com.bear.bookhouse.pojo.Picture;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:11
 */
public class PictureDaoImpl extends BaseDao implements PictureDao {
    @Override
    public Picture getPictureById(int id) {
        String sql = "SELECT `id`,`views`,`downloads`,`collections`,`likes`,`comments`,`tags`,`image_width` width,`image_height` height,`image_size` size,`large_image_url` url, `add_time` addTime FROM `t_pixabay` WHERE id = ?;";
        Object[] params = new Object[]{id};
        return getRecord(Picture.class, sql, params);
    }

    @Override
    public Long getAllPicturesCount() {
        String sql = "SELECT COUNT(`id`) FROM `t_pixabay`;";
        return (Long) getSingleValue(sql);
    }
}
