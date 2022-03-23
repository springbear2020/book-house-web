package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.pojo.Favorite;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:27
 */
public class FavoriteDaoImpl extends BaseDao implements FavoriteDao {
    @Override
    public int saveFavorite(Favorite favorite) {
        String sql = "INSERT INTO `t_favorite`(`user_id`,`book_id`,`time`) VALUES (?,?,?);";
        return update(sql, favorite.getUserId(), favorite.getBookId(), favorite.getTime());
    }
}
