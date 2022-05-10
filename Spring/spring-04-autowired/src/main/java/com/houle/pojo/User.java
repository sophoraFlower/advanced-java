package com.houle.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class User {

//    @Autowired
//    @Qualifier(value = "cat2")
    @Resource(name = "cat1")
    private Cat cat;
//    @Autowired
//    @Qualifier(value = "dog2")
    @Resource(name = "dog1")
    private Dog dog;
    private String str;

    public Cat getCat() {
        return cat;
    }

//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    public Dog getDog() {
        return dog;
    }

//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }

    public String getStr() {
        return str;
    }

//    public void setStr(String str) {
//        this.str = str;
//    }
}
