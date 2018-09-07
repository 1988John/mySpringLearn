package com.foo.test.designPattern.singleton.doublechecklock;

/**
 * 双重检验锁
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class Singleton {

    private volatile static Singleton singleton;

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
