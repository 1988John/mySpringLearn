package com.foo.test.designPattern.singleton.staticinner;

/**
 * 静态内部类
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class Singleton {

    private static class SingletonHandler{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return SingletonHandler.singleton;
    }
}
