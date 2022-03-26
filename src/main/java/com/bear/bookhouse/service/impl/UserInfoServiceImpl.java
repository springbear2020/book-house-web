package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.UserInfoDao;
import com.bear.bookhouse.dao.impl.UserInfoImpl;
import com.bear.bookhouse.pojo.UserInfo;
import com.bear.bookhouse.service.UserInfoService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:26
 */
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao = new UserInfoImpl();

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfoByUserId(userInfo) == 1;
    }
}
