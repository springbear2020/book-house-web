package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.UserInfo;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:04
 */
public interface UserInfoDao {
    /**
     * 保存用户信息
     *
     * @param userInfo 用户信息
     * @return 1 - 保存成功
     */
    int saveUserInfo(UserInfo userInfo);

    /**
     * 通过用户 id 查询用户信息
     *
     * @param userId 用户 id
     * @return UserInfo or null
     */
    UserInfo getUserInfoByUserId(int userId);
}
