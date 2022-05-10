package com.houle.service.impl;

import com.houle.service.UserService;
import org.springframework.stereotype.Component;

// 被增强的类
@Component("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void search() {
        System.out.println("搜索用户");
    }
}
