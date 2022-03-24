package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UserDao;
import com.bear.bookhouse.pojo.User;
import com.bear.bookhouse.util.NumberUtil;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:15
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`portrait_path` portraitPath, `score`,`register_date` registerDate FROM `t_user` WHERE `username` = ?;";
        return getRecord(User.class, sql, username);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`portrait_path` portraitPath, `score`,`register_date` registerDate FROM `t_user` WHERE `username` = ? AND `password` = ?;";
        return getRecord(User.class, sql, username, password);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`portrait_path` portraitPath, `score`,`register_date` registerDate FROM `t_user` WHERE `email` = ? AND `password` = ?;";
        return getRecord(User.class, sql, email, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `t_user`(`username`,`password`,`email`,`portrait_path`,`score`,`register_date`) VALUES (?,?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getPortraitPath(), user.getScore(), user.getRegisterDate());
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`portrait_path` portraitPath, `score`,`register_date` registerDate FROM `t_user` WHERE `email` = ?;";
        return getRecord(User.class, sql, email);
    }

    @Override
    public int updatePasswordByEmail(String password, String email) {
        String sql = "UPDATE `t_user` SET `password` = ? WHERE `email` = ?;";
        return update(sql, password, email);
    }

    @Override
    public int addUserScoreById(int addScore, int userId) {
        String sql = "UPDATE `t_user` SET `score` = `score` + ? WHERE `id` = ?;";
        return update(sql, addScore, userId);
    }

    @Override
    public int subUserScoreByUser(int subScore, int userId) {
        String sql = "UPDATE `t_user` SET `score` = `score` - ? WHERE `id` = ?;";
        return update(sql, subScore, userId);
    }

    @Override
    public int getUserScoreById(int userId) {
        String sql = "SELECT `score` FROM `t_user` WHERE `id` = ?;";
        return NumberUtil.objectToInteger(getSingleValue(sql, userId), -1);
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT `id`,`username`,`password`,`email`,`portrait_path` portraitPath, `score`,`register_date` registerDate FROM `t_user` WHERE `id` = ?;";
        return getRecord(User.class, sql, userId);
    }
}
