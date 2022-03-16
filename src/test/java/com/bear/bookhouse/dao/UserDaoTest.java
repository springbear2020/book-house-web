package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.UserDaoImpl;
import com.bear.bookhouse.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.Date;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:23
 */
class UserDaoTest {
    private final UserDao userDao = new UserDaoImpl();

    @Test
    void queryUserByUsername() {
        String username = "admin";
        User user = userDao.queryUserByUsername(username);
        System.out.println(user);
    }

    @Test
    void queryUserByUsernameAndPassword() {
        String username = "admin";
        String password = "admin";
        User user = userDao.queryUserByUsernameAndPassword(username, password);
        System.out.println(user);
    }

    @Test
    void saveUser() {
        User user = new User(null, "admin", "admin", "admin@admin.com", new Date());
        int i = userDao.saveUser(user);
        System.out.println(i);
    }
}