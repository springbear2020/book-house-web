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
     * @return true - exists
     */
    boolean isUsernameExists(String username);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return true - exists
     */
    boolean isUsernameAndPasswordCorrect(String username, String password);

    /**
     * 验证邮箱地址是否已存在
     *
     * @param email 邮箱地址
     * @return true - exists
     */
    boolean isEmailExists(String email);

    /**
     * 通过用户邮箱信息更新用户密码
     *
     * @param email    邮箱
     * @param password 密码
     * @return true - 更新成功
     */
    boolean updateUserPasswordByEmail(String password, String email);

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return User or null
     */
    User getUserByUsername(String username);

    /**
     * 增加用户积分，默认增加 10 分
     * // TODO 返回值
     * @param userId 用户 id
     * @return true - 增加成功
     */
    boolean addUserScore(int userId);

    /**
     * 减少用户积分，默认减少 10 分
     * // TODO 返回值
     * @param userId 用户 id
     * @return true - 减少成功
     */
    boolean subUserScore(int userId);

    /**
     * 查询用户积分
     *
     * @param userId 用户 id
     * @return 用户积分
     */
    int getUserScore(int userId);
}
