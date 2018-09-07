package com.foo.test.designPattern.singleton.lazy;

/**
 * 懒汉式
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class Singleton {
    private static Singleton singleton;

    public static Singleton getSingleton(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
