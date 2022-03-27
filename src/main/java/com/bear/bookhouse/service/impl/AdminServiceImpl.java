package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.AdminDao;
import com.bear.bookhouse.dao.impl.AdminDaoImpl;
import com.bear.bookhouse.pojo.Admin;
import com.bear.bookhouse.service.AdminService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/27 11:41
 */
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        return adminDao.getAdminByUsernameAndPassword(username, password);
    }
}
