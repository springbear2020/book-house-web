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
    public int saveUserInfo(UserInfo userInfo) {
        String sql = "INSERT INTO `t_user_info`(`user_id`,`nickname`,`sex`,`birth`,`location`,`signature`,`collections`,`uploads`,`downloads`,`last_update_time`) VALUES (?,?,?,?,?,?,?,?,?,?);";
        return update(sql, userInfo.getUserId(), userInfo.getNickname(), userInfo.getSex(), userInfo.getBirth(), userInfo.getLocation(), userInfo.getSignature(), userInfo.getCollections(), userInfo.getUploads(), userInfo.getDownloads(), userInfo.getLastUpdateTime());
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        String sql = "SELECT `id`,`user_id` userId,`nickname`,`sex`,`birth`,`location`,`signature`,`collections`,`uploads`,`downloads`,`last_update_time` lastUpdateTime FROM `t_user_info` WHERE `user_id` = ?;";
        return getRecord(UserInfo.class, sql, userId);
    }
}
