package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.LoginLog;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:33
 */
public interface LoginLogService {
    /**
     * 田间用户登录记录
     *
     * @param loginLog 用户登录记录
     * @return true - 添加成功
     */
    boolean addLoginLog(LoginLog loginLog);

    /**
     * 通过用户 id 查询用户登录日志
     *
     * @param userId 用户 id
     * @return 登录日志
     */
    List<LoginLog> listLoginLogsByUserId(int userId);
}
