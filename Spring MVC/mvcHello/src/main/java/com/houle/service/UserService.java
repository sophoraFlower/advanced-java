package com.houle.service;

import com.houle.entity.User;

public class UserService {
    public User getUser() {
        return new User(1, "User 1");
    }
}
