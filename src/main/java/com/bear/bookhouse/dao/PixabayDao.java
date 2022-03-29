package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Pixabay;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:18
 */
public interface PixabayDao {
    /**
     * 通过 id 获取图片
     *
     * @param id id
     * @return Pixabay
     */
    Pixabay getPixabayById(int id);

    /**
     * 获取图片总记录数
     *
     * @return 总记录数
     */
    int getPixabayCounts();

    /**
     * 通过 id 删除图片
     *
     * @param id id
     * @return 1 - 删除成功
     */
    int deletePixabayById(int id);

    /**
     * 删除所有 pixabay 图片
     *
     * @return 1 - 删除成功
     */
    int deleteAllPixabay();

    /**
     * 重置自增 id 为 1
     *
     * @return 1 - 重置成功
     */
    int resetIncrement();
}
