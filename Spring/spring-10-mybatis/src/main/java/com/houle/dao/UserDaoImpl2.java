package com.houle.dao;

import com.houle.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl2 extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> selectUser() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
