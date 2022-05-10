package com.houle.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SmsServiceInvocationHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public SmsServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用方法之前，可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        // 调用方法之后，同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
