package com.houle.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 生成代理对象
public class UserServiceProxy {

    // 前置通知
    @Before(value = "execution(* com.houle.service.impl.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("before......");
    }

    @After(value = "execution(* com.houle.service.impl.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("after......");
    }
}
