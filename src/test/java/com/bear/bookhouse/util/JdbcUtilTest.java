package com.bear.bookhouse.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/19 9:03
 */
public class JdbcUtilTest {
    @Test
    public void getConnection() throws SQLException {
     Connection connection = JdbcUtil.getConnection();
     System.out.println(connection);
     JdbcUtil.close(connection);
    }
}