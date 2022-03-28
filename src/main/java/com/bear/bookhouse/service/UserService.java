package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Admin;
import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.pojo.UserInfo;

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
     * 验证用户名是否已存在
     *
     * @param username 用户名
     * @return true - 已存在
     */
    boolean isUsernameExists(String username);

    /**
     * 验证用户名及密码是否正确
     *
     * @param username 用户名
     * @param password 密码
     * @return true - 正确
     */
    boolean isUsernameAndPasswordCorrect(String username, String password);

    /**
     * 验证邮箱及密码是否正确
     *
     * @param email    邮箱
     * @param password 密码
     * @return true - 正确
     */
    boolean isEmailAndPasswordCorrect(String email, String password);

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
    boolean updatePasswordByEmail(String password, String email);

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return User or null
     */
    User getUserByUsername(String username);

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return User or null
     */
    User getUserByEmail(String email);

    /**
     * 增加用户积分，默认增加 10 分
     *
     * @param addScore 增加的分数
     * @param userId   用户 id
     * @return true - 增加成功
     */
    boolean addUserScore(int addScore, int userId);

    /**
     * 减少用户积分，默认减少 10 分
     *
     * @param subScore 减少的分数
     * @param userId   用户 id
     * @return true - 减少成功
     */
    boolean subUserScore(int subScore, int userId);

    /**
     * 查询用户积分
     *
     * @param userId 用户 id
     * @return 用户积分
     */
    int getUserScore(int userId);

    /**
     * 验证用户 id 是否已存在
     *
     * @param userId 用户 id
     * @return true - 已存在
     */
    boolean isUserIdExists(int userId);

    /**
     * 更新用户头像
     *
     * @param userId       用户 id
     * @param portraitPath 用户头像路径
     * @return true - 更新成功
     */
    boolean updateUserPortrait(String portraitPath, int userId);

    /**
     * 通过用户 id 查询用户
     *
     * @param userId 用户 id
     * @return User or null
     */
    User getUserById(int userId);

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

    /**
     * 通过用户名、密码查询管理员信息
     *
     * @param username 用户名
     * @param password 密码
     * @return Admin or null
     */
    Admin getAdminByUsernameAndPassword(String username, String password);
}
