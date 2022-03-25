package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.LoginLogDao;
import com.bear.bookhouse.dao.impl.LoginLogDaoImpl;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.service.LoginLogService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:34
 */
public class LoginLogServiceImpl implements LoginLogService {
    private final LoginLogDao loginLogDao = new LoginLogDaoImpl();

    @Override
    public boolean addLoginLog(LoginLog loginLog) {
        return loginLogDao.saveLoginLog(loginLog) == 1;
    }

    @Override
    public List<LoginLog> listLoginLogsByUserId(int userId) {
        return loginLogDao.listLoginLogsByUserId(userId);
    }
}
