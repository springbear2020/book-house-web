package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:11
 */
public interface UserDao {

    /**
     * 保存用户信息
     *
     * @param user User
     * @return -1 - 保存失败； 1 - 保存成功
     */
    int saveUser(User user);

    /**
     * 通过用户 id 查询用户信息
     *
     * @param userId 用户 id
     * @return User or null
     */
    User getUserById(int userId);

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return user or null
     */
    User getUserByUsername(String username);

    /**
     * 根据用户名及密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return user or null
     */
    User getUserByUsernameAndPassword(String username, String password);

    /**
     * 根据邮箱及密码查询用户信息
     *
     * @param email    邮箱
     * @param password 密码
     * @return User or null
     */
    User getUserByEmailAndPassword(String email, String password);

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱地址
     * @return User or null
     */
    User getUserByEmail(String email);

    /**
     * 通过用户邮箱信息更新用户密码
     *
     * @param email    邮箱
     * @param password 密码
     * @return 1 - 更新成功
     */
    int updatePasswordByEmail(String password, String email);

    /**
     * 通过用户 id 增加用户积分
     *
     * @param addScore 增加的积分量
     * @param userId   用户 id
     * @return 1 - 增加成功
     */
    int addUserScoreByUserId(int addScore, int userId);

    /**
     * 通过用户 id 减少用户积分
     *
     * @param subScore 减少的积分量
     * @param userId   用户 id
     * @return 1 - 减少成功
     */
    int subUserScoreByUserId(int subScore, int userId);

    /**
     * 通过用户 id 查询用户积分
     *
     * @param userId 用户 id
     * @return 用户积分
     */
    int getUserScoreByUserId(int userId);

    /**
     * 通过用户 id 更新用户头像保存路径
     *
     * @param userId       用户 id
     * @param portraitPath 头像路径
     * @return 1 - 更新成功
     */
    int updatePortraitPathByUserId(String portraitPath, int userId);
}
