package com.foo.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Fooisart
 * @date 19:03 21-02-2019
 */
public class User {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        User user = new User();
        user.setAge(12);
        user.setName("jw");
        try {
            Map map = BeanUtils.describe(user);
            map.remove("class");
            map.remove("age");
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
