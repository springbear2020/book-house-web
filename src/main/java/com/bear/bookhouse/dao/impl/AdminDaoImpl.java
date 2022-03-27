package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.AdminDao;
import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.pojo.Admin;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/27 11:37
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`register_date` registerDate FROM `t_admin` WHERE `username` = ? AND `password` = ?;";
        return getRecord(Admin.class, sql, username, password);
    }
}
