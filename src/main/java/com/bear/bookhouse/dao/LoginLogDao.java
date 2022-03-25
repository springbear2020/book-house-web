package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.LoginLog;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:22
 */
public interface LoginLogDao {
    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return 1 - 保存成功
     */
    int saveLoginLog(LoginLog loginLog);

    /**
     * 通过用户 id 查询用户登录日志
     *
     * @param userId 用户 id
     * @return 登录日志
     */
    List<LoginLog> listLoginLogsByUserId(int userId);
}
