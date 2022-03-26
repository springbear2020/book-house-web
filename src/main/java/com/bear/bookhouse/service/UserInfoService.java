package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.UserInfo;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:25
 */
public interface UserInfoService {
    /**
     * 通过用户 id 查询用户信息
     *
     * @param userId 用户 id
     * @return UserInfo or null
     */
    UserInfo getUserInfoByUserId(int userId);

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息
     * @return true - 更新成功
     */
    boolean updateUserInfo(UserInfo userInfo);
}
