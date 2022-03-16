package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:58
 */
public interface UserService {
    /**
     * 保存用户信息
     *
     * @param user User
     * @return true - 保存成功
     */
    boolean saveUser(User user);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return User or null
     */
    User queryUserByUsername(String username);
}
