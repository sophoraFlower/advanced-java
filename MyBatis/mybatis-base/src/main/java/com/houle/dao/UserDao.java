package com.houle.dao;

import com.houle.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectUser();
    // 根据id查询用户
    User selectUserById(int id);
    // 根据名字查询用户
    User selectUserByName(String name);
    // 通过密码和名字查询用户
    User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);
    User selectUserByNP2(Map<String,Object> map);
    // 添加一个用户
    int addUser(User user);
    // 修改一个用户
    int updateUser(User user);
    // 删除一个用户
    int deleteUser(User user);
}
