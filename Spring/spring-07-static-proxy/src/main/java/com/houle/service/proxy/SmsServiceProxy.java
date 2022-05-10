package com.houle.service.proxy;

import com.houle.service.SmsService;

// 将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法
public class SmsServiceProxy implements SmsService {
    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    // 通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些额外的操作
    @Override
    public String send(String message) {
        // 调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        System.out.println("send message: " + message);
        // 调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return message;
    }
}
