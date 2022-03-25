package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.UserInfoImpl;
import com.bear.bookhouse.pojo.UserInfo;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:14
 */
public class UserInfoDaoTest {
    private final UserInfoDao userInfoDao = new UserInfoImpl();

    @Test
    public void saveUserInfo() {
        System.out.println(userInfoDao.saveUserInfo(new UserInfo(null, 3, "Bear", "男", new Date(), "贵州省", "短相思兮无穷极", 33, 33, 33, new Date())));
    }

    @Test
    public void getUserInfoByUserId() {
        System.out.println(userInfoDao.getUserInfoByUserId(2));
    }
}