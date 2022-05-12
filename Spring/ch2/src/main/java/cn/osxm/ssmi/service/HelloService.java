package cn.osxm.ssmi.service;

import cn.osxm.ssmi.dao.HelloDao;

public class HelloService {
    private String name;
    private HelloDao helloDao;

    public HelloService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public void sayHello() {
        System.out.println("Hello " + this.name);
        helloDao.insert();
    }
}
