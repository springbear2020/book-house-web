package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.FavoriteService;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:32
 */
public class FavoriteServiceImplTest {
    private final FavoriteService favoriteService = new FavoriteServiceImpl();

    @Test
    public void addFavorite() {
        boolean b = favoriteService.addFavorite(new Favorite(null, 1, 1, new Date()));
        System.out.println(b);
    }
}