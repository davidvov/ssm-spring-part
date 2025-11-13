package com.atguigu.ioc_02;

public class UserService2 {
    private UserDao userDao;
    private int age;
    private String name;
    public UserService2(int age,String name,UserDao userDao){
        this.age = age;
        this.name = name;
        this.userDao = userDao;
    }
}
