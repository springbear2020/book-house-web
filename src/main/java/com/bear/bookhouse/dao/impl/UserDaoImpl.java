package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UserDao;
import com.bear.bookhouse.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:15
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`score`,`register_date` registerDate FROM `t_user` WHERE `username` = ?;";
        return getRecord(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`score`,`register_date` registerDate FROM `t_user` WHERE `username` = ? AND `password` = ?;";
        return getRecord(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `t_user`(`username`,`password`,`email`,`score`,`register_date`) VALUES (?,?,?,?,?)";
        Object[] params = new Object[]{user.getUsername(), user.getPassword(), user.getEmail(), user.getScore(), user.getRegisterDate()};
        return update(sql, params);
    }

    @Override
    public User queryUserByEmail(String email) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`score`,`register_date` registerDate FROM `t_user` WHERE `email` = ?;";
        return getRecord(User.class, sql, email);
    }

    @Override
    public int updateUserByEmail(String password, String email) {
        String sql = "UPDATE `t_user` SET `password` = ? WHERE `email` = ?;";
        return update(sql, password, email);
    }
}
