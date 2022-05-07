package com.houle.dao.impl;

import com.houle.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取用户数据");
    }
}
