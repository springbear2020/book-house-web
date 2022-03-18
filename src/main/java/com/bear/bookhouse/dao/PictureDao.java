package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Picture;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:08
 */
public interface PictureDao {
    /**
     * 通过 id 获取图片信息
     *
     * @param id id
     * @return Picture or null
     */
    Picture getPictureById(int id);

    /**
     * 获取图片总数量
     *
     * @return 图片数量
     */
    Long getAllPicturesCount();
}
