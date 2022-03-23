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
        String sql = "INSERT INTO `t_favorite`(`user_id`,`book_id`,`title`,`author`,`translator`,`collect_time`) VALUES (?,?,?,?,?,?);";
        return update(sql, favorite.getUserId(), favorite.getBookId(),favorite.getTitle(),favorite.getAuthor(),favorite.getTranslator(), favorite.getCollectTime());
    }

    @Override
    public Favorite queryFavoriteByBookId(int id) {
        String sql = "SELECT `id`,`user_id` userId,`book_id` bookId,`title`,`author`,`translator`,`collect_time` collectTime FROM `t_favorite` WHERE `book_id` = ?;";
        return getRecord(Favorite.class, sql, id);
    }
}
