package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Favorite;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:26
 */
public interface FavoriteDao {
    /**
     * 保存收藏记录
     *
     * @param favorite 收藏记录
     * @return 1 - 保存成功
     */
    int saveFavorite(Favorite favorite);
}
