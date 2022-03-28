package com.bear.bookhouse.dao;


import com.bear.bookhouse.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 18:54
 */
public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行 insert、update、delete 语句
     *
     * @param sql    sql
     * @param params sql 实参
     * @return 受影响的行数
     */
    public int update(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return -1;
    }

    /**
     * 查询数据库表的一条记录
     *
     * @param clazz  JavaBean class 对象
     * @param sql    sql
     * @param params sql 实参
     * @param <T>    返回类型泛型
     * @return 一条记录 or null
     */
    public <T> T getRecord(Class<T> clazz, String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多条数据库表记录
     *
     * @param clazz  JavaBean 的 class 对象
     * @param sql    sql
     * @param params sql 实参
     * @param <T>    返回类型的泛型
     * @return 多条记录 or null
     */
    public <T> List<T> listRecord(Class<T> clazz, String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }

    /**
     * 查询返回单个数值
     *
     * @param sql    sql
     * @param params sql 实参
     * @return 单个数值 or null
     */
    public Object getSingleValue(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }
}