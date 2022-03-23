package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Favorite;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:30
 */
public interface FavoriteService {
    /**
     * 添加用户图书收藏记录
     *
     * @param favorite 收藏记录
     * @return true - 添加成功
     */
    boolean addFavorite(Favorite favorite);

    /**
     * 通过图书 id 判断收藏记录是否已存在
     *
     * @param booId 图书 id
     * @return true - 收藏记录已存在
     */
    boolean isFavoriteExists(int booId);
}
