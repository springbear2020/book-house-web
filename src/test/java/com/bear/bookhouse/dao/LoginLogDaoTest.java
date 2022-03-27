package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.LoginLogDaoImpl;
import com.bear.bookhouse.pojo.LoginLog;
import org.junit.Test;

import java.util.Date;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:29
 */
public class LoginLogDaoTest {
    private final LoginLogDao loginLogDao = new LoginLogDaoImpl();

    @Test
    public void saveLoginLog() {
        System.out.println(loginLogDao.saveLoginLog(new LoginLog(null, 2, "Spring-_-Bear", "10.130.227.37", "湖北省武汉市", new Date())));
    }

    @Test
    public void listLoginLogsByUserId() {
        System.out.println(loginLogDao.listLoginLogsByUserId(2, 1, 15));
    }
}