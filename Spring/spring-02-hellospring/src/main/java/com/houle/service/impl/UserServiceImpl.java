package com.houle.service.impl;

import com.houle.dao.UserDao;
import com.houle.dao.impl.UserDaoImpl;
import com.houle.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    // private UserDao userDao = new UserDaoMySqlImpl();
    // private UserDao userDao = new UserDaoOracleImpl();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
