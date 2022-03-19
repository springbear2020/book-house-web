package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.UserDao;
import com.bear.bookhouse.dao.impl.UserDaoImpl;
import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.service.UserService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:59
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean saveUser(User user) {
        if (user == null) {
            return false;
        }
        return userDao.saveUser(user) == 1;
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }
}
