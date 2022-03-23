package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.pojo.Favorite;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 16:33
 */
public class FavoriteDaoImplTest {
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Test
    public void queryFavoriteByBookId() {
        Favorite favorite = favoriteDao.queryFavoriteByBookId(5);
        System.out.println(favorite);
    }
}