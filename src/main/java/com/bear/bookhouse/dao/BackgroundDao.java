package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Background;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/29 15:26
 */
public interface BackgroundDao {
    /**
     * 保存背景
     *
     * @param background 背景
     * @return 1 - 保存成功
     */
    int saveBackground(Background background);

    /**
     * 通过 id 获取背景
     *
     * @param id id
     * @return Background or null
     */
    Background getBackgroundById(int id);

    /**
     * 获取背景记录总数
     *
     * @return 记录总数
     */
    int getBackgroundCounts();
}
