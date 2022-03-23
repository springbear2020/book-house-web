package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.dao.impl.FavoriteDaoImpl;
import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.FavoriteService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:31
 */
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean addFavorite(Favorite favorite) {
        return favoriteDao.saveFavorite(favorite) == 1;
    }

    @Override
    public boolean isFavoriteExists(int userId, int booId) {
        return favoriteDao.queryFavoriteByUserIdAndBookId(userId, booId) != null;
    }

    @Override
    public List<Favorite> getUserFavoritesByUserId(int userId) {
        return favoriteDao.queryFavoritesByUserId(userId);
    }

    @Override
    public boolean deleteUserFavorite(int userId, int bookId) {
        return favoriteDao.deleteUserFavoriteByUserIdAndBookId(userId, bookId) == 1;
    }
}
