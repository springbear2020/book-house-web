package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:11
 */
public interface UserDao {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return user or null
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名及密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return user or null
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user User
     * @return -1 - 保存失败； 1 - 保存成功
     */
    int saveUser(User user);
}
