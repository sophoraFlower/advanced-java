package com.houle;

import com.houle.proxy.DebugInvocationHandler;
import com.houle.proxy.ProxyInvocationHandler;
import com.houle.proxy.SmsProxy;
import com.houle.service.SmsService;
import com.houle.service.SmsServiceImpl;

public class Main {

    private static ProxyInvocationHandler JdkProxyFactory;

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");

        SmsService smsServiceNew = (SmsService) DebugInvocationHandler.getProxy(new SmsServiceImpl());
        smsServiceNew.send("java proxy");
    }

}
