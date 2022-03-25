package com.bear.bookhouse.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 18:56
 */
public class JdbcUtil {
    private static int connections = 0;
    private static DataSource dataSource;

    // 静态代码块从配置文件读取配置信息
    static {
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从 Druid 数据库连接池中获得一个数据库连接对象
     *
     * @return Connection
     * @throws SQLException exception
     */
    public static Connection getConnection() throws SQLException {
        System.out.println("Database connections：" + (++connections));
        return dataSource.getConnection();
    }

    /**
     * 归还连接对象到连接池
     *
     * @param connection Connection
     */
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

