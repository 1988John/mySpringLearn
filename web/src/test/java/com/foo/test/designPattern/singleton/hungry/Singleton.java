package com.foo.test.designPattern.singleton.hungry;

/**
 * 饿汉式
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton(){
        return singleton;
    }
}
