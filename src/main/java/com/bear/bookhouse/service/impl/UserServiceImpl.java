package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.AdminDao;
import com.bear.bookhouse.dao.UserDao;
import com.bear.bookhouse.dao.UserInfoDao;
import com.bear.bookhouse.dao.impl.AdminDaoImpl;
import com.bear.bookhouse.dao.impl.UserDaoImpl;
import com.bear.bookhouse.dao.impl.UserInfoImpl;
import com.bear.bookhouse.pojo.Admin;
import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.pojo.UserInfo;
import com.bear.bookhouse.service.UserService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:59
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    private final UserInfoDao userInfoDao = new UserInfoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user) == 1;
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userDao.getUserByUsername(username) != null;
    }

    @Override
    public boolean isUsernameAndPasswordCorrect(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password) != null;
    }

    @Override
    public boolean isEmailExists(String email) {
        return userDao.getUserByEmail(email) != null;
    }

    @Override
    public boolean updatePasswordByEmail(String password, String email) {
        return userDao.updatePasswordByEmail(password, email) == 1;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public boolean addUserScore(int addScore, int userId) {
        return userDao.addUserScoreByUserId(addScore, userId) == 1;
    }

    @Override
    public boolean subUserScore(int subScore, int userId) {
        return userDao.subUserScoreByUserId(subScore, userId) == 1;
    }

    @Override
    public int getUserScore(int userId) {
        return userDao.getUserScoreByUserId(userId);
    }

    @Override
    public boolean isUserIdExists(int userId) {
        return userDao.getUserById(userId) == null;
    }

    @Override
    public boolean isEmailAndPasswordCorrect(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password) != null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean updateUserPortrait(String portraitPath, int userId) {
        return userDao.updatePortraitPathByUserId(portraitPath, userId) == 1;
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfoByUserId(userInfo) == 1;
    }

    @Override
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        return adminDao.getAdminByUsernameAndPassword(username, password);
    }
}
