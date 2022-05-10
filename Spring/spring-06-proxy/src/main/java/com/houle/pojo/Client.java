package com.houle.pojo;

import com.houle.proxy.ProxyInvocationHandler;
import com.houle.service.SmsServiceImpl;
import com.houle.service.UserServiceImpl;
import com.houle.service.UserServiceProxy;

public class Client {
    // 客户类，一般客户都会去找代理！
    public static void main(String[] args) {
        // 房东要租房
        Host host = new Host();
        // 中介帮助房东
        Proxy proxy = new Proxy(host);
        // 你去找中介！
        proxy.rent();

        // 真实业务
        UserServiceImpl userService = new UserServiceImpl();
        // 代理类
        UserServiceProxy proxy1 = new UserServiceProxy();
        // 使用代理类实现日志功能！
        proxy1.setUserService(userService);
        proxy1.add();

        // 真实角色
        Host host1 = new Host();
        // 代理实例的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host); // 将真实角色放置进去！
        Rent proxy2 = (Rent) pih.getProxy(new SmsServiceImpl()); // 动态生成对应的代理类！
        proxy2.rent();
    }

}
