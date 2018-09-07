package com.foo.test.designPattern.singleton.lazy;

/**
 * 懒汉式（线程安全）
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class SingletonSynchroized {

    private static SingletonSynchroized singleton;

    public static synchronized SingletonSynchroized getSingleton(){
        if (singleton == null){
            singleton = new SingletonSynchroized();
        }
        return singleton;
    }
}
