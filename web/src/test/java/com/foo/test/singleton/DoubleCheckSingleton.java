package com.foo.test.singleton;

/**
 * @author jiangwang
 * @date 2021-02-27 08:51
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
