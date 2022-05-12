package cn.osxm.ssmi.service.impl;

import cn.osxm.ssmi.dao.UserDao;
import cn.osxm.ssmi.pojo.User;
import cn.osxm.ssmi.service.UserService;

public class UserServiceImpl implements UserService {
    private User user;

    public UserServiceImpl(User user) {
        this.user = user;
    }

    @Override
    public void add(String username) {
        User user = new User();
        user.setUsername(username);
    }
}
