package com.houle.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="com.houle.pojo.User" />
@Component("user")
public class User {

    // 相当于配置文件中 <property name="name" value="後楽"/>
    @Value("後楽")
    public String name;
}
