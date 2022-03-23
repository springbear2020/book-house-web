package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.dao.impl.FavoriteDaoImpl;
import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.FavoriteService;

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
    public boolean isFavoriteExists(int booId) {
        return favoriteDao.queryFavoriteByBookId(booId) != null;
    }
}
