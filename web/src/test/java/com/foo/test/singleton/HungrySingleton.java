package com.foo.test.singleton;

/**
 * @author jiangwang
 * @date 2021-02-27 08:31
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
