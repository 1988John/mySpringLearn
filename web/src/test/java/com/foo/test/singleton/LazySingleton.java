package com.foo.test.singleton;

/**
 * @author jiangwang
 * @date 2021-02-27 08:27
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
