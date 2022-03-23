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
     * 通过图书 id 查询收藏记录
     *
     * @param bookId 图书 id
     * @return Favorite or null
     */
    Favorite queryFavoriteByBookId(int bookId);

    /**
     * 通过用户 id 查询收藏记录
     *
     * @param userId 用户 id
     * @return Favorites or null
     */
    List<Favorite> queryFavoritesByUserId(int userId);
}
