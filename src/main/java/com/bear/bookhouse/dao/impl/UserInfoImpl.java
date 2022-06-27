package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UserInfoDao;
import com.bear.bookhouse.pojo.UserInfo;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:06
 */
public class UserInfoImpl extends BaseDao implements UserInfoDao {
    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        String sql = "SELECT `id`,`user_id` userId,`nickname`,`sex`,`birth`,`location`,`signature`,`collections`,`uploads`,`downloads`,`last_update_time` lastUpdateTime FROM `t_user_info` WHERE `user_id` = ?;";
        return getRecord(UserInfo.class, sql, userId);
    }

    @Override
    public int updateUserInfoByUserId(UserInfo userInfo) {
        String sql = "UPDATE `t_user_info` SET `nickname` = ?, `sex` = ?, `birth` = ?,`location` = ?,`signature` = ?,`last_update_time` = ? WHERE `user_id` = ?;";
        return update(sql, userInfo.getNickname(), userInfo.getSex(), userInfo.getBirth(), userInfo.getLocation(), userInfo.getSignature(), userInfo.getLastUpdateTime(), userInfo.getUserId());
    }

    @Override
    public int saveUseInfo(Integer userId) {
        String sql = "INSERT INTO t_user_info(`user_id`) VALUES ?;";
        return update(sql, userId);
    }
}
