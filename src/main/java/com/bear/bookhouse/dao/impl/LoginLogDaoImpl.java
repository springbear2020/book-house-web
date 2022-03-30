package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.LoginLogDao;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.util.NumberUtil;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:26
 */
public class LoginLogDaoImpl extends BaseDao implements LoginLogDao {
    @Override
    public int saveLoginLog(LoginLog loginLog) {
        String sql = "INSERT INTO `log_login`(`user_id`,`username`,`ip`,`location`,`time`) VALUES (?,?,?,?,?);";
        return update(sql, loginLog.getUserId(), loginLog.getUsername(), loginLog.getIp(), loginLog.getLocation(), loginLog.getTime());
    }

    @Override
    public List<LoginLog> listLoginLogsThoughUserIdByBeginAndOffset(int userId, int begin, int offset) {
        String sql = "SELECT `id`,`user_id` userId,`username`,`ip`,`location`,`time` FROM `log_login` WHERE `user_id` = ? ORDER BY `time` DESC LIMIT ?,?;";
        return listRecord(LoginLog.class, sql, userId, begin, offset);
    }

    @Override
    public int getUserLoginLogCounts(int userId) {
        String sql = "SELECT COUNT(`id`) FROM `log_login` WHERE `user_id` = ?;";
        return NumberUtil.objectToInteger(getSingleValue(sql, userId), LoginLog.ERROR);
    }
}
