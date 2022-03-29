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
     * 通过 id 删除图片
     *
     * @param id id
     * @return true - 删除成功
     */
    boolean deletePixabayById(int id);

    /**
     * 删除所有 pixabay 图书并重置自增 id 为 1
     *
     * @return boolean 删除成功且重置成功
     */
    boolean deleteAllPixabayAndReset();
}
