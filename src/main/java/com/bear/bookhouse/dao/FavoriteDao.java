package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Favorite;

import java.util.List;

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

    /**
     * 通过用户 id 和图书 id 查询收藏记录
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     * @return Favorite or null
     */
    Favorite getFavoriteByUserIdAndBookId(int userId, int bookId);

    /**
     * 通过用户 id 查询收藏记录
     *
     * @param userId 用户 id
     * @return Favorites or null
     */
    List<Favorite> listFavoritesByUserId(int userId);

    /**
     * 通过用户 id 和图书 id 删除用户对应的收藏记录
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     * @return 1 - 删除成功
     */
    int deleteFavoriteByUserIdAndBookId(int userId, int bookId);
}
