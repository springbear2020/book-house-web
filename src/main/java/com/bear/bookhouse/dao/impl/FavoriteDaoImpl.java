package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.pojo.Favorite;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:27
 */
public class FavoriteDaoImpl extends BaseDao implements FavoriteDao {
    @Override
    public int saveFavorite(Favorite favorite) {
        String sql = "INSERT INTO `t_favorite`(`user_id`,`book_id`,`title`,`author`,`cover_path`,`collect_time`) VALUES (?,?,?,?,?,?);";
        return update(sql, favorite.getUserId(), favorite.getBookId(), favorite.getTitle(), favorite.getAuthor(), favorite.getCoverPath(), favorite.getCollectTime());
    }

    @Override
    public Favorite getFavoriteByUserIdAndBookId(int userId, int bookId) {
        String sql = "SELECT `id`,`user_id` userId,`book_id` bookId,`title`,`author`,`cover_path` coverPath,`collect_time` collectTime FROM `t_favorite` WHERE `user_id` = ? AND `book_id` = ?;";
        return getRecord(Favorite.class, sql, userId, bookId);
    }

    @Override
    public List<Favorite> listFavoritesByUserId(int userId) {
        String sql = "SELECT `id`,`user_id` userId,`book_id` bookId,`title`,`author`,`cover_path` coverPath,`collect_time` collectTime FROM `t_favorite` WHERE `user_id` = ?;";
        return listRecord(Favorite.class, sql, userId);
    }

    @Override
    public int deleteFavoriteByUserIdAndBookId(int userId, int bookId) {
        String sql = "DELETE FROM `t_favorite` WHERE `user_id` = ? AND `book_id` = ?;";
        return update(sql, userId, bookId);
    }
}
