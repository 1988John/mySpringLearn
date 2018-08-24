package com.foo.test.base.serializable;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class User{

    String userName ;
    
    String password;

    public User(String userName , String passwrod) {
        this.userName = userName;
        this.password = passwrod;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        User user = new User("ab","abc");
        System.out.println(JSON.toJSONString(user));
    }
    
//    @Override
//    public String toString() {
//        return "用户名："+this.userName+ " 密码："+ this.password;
//    }
}
