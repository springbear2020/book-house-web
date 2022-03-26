package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Favorite;

import java.util.List;

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
     * 通过用户 id 和图书 id 判断收藏记录是否已存在
     *
     * @param userId 用户 id
     * @param booId  图书 id
     * @return true - 收藏记录已存在
     */
    boolean isFavoriteExists(int userId, int booId);

    /**
     * 通过用户 id 查询用户收藏记录
     *
     * @param userId 用户 id
     * @return Favorites or null
     */
    List<Favorite> getFavorites(int userId);

    /**
     * 删除用户图书收藏记录
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     * @return true - 删除成功
     */
    boolean deleteFavorite(int userId, int bookId);
}
