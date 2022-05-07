package com.houle.dao.impl;

import com.houle.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("MySql获取用户数据");
    }
}
