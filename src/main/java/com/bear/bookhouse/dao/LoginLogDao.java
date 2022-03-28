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
     * 通过用户 id 查询用户登录日志，
     * 并指定起始位置和偏移量以获取分页数据
     *
     * @param userId 用户 id
     * @param begin  起始位置
     * @param offset 偏移量
     * @return 登录日志
     */
    List<LoginLog> listLoginLogsThoughUserIdByBeginAndOffset(int userId, int begin, int offset);

    /**
     * 获取用户的登录记录总记录数
     *
     * @param userId 用户 id
     * @return 总记录数
     */
    int getUserLoginLogCounts(int userId);
}
