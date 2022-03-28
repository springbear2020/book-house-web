package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Pixabay;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:45
 */
public interface PixabayService {
    /**
     * 随机获取一张图片
     *
     * @return Pixabay or null
     */
    Pixabay getPixabayRandomly();

    /**
     * 获取图片总数
     *
     * @return 总数
     */
    int getPixabayCounts();

    /**
     * 通过 id 删除图片
     *
     * @param id id
     * @return true - 删除成功
     */
    boolean deletePixabayById(int id);

    /**
     * 展示一张数据库表第一张图书
     *
     * @return Pixabay
     */
    Pixabay showFirstPixabay();
}
