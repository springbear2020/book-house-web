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
}
