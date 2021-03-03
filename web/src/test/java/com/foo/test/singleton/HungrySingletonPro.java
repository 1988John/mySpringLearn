package com.foo.test.singleton;

/**
 * @author jiangwang
 * @date 2021-02-27 08:31
 */
public class HungrySingletonPro {
    private static HungrySingletonPro instance;

    static {
        instance = new HungrySingletonPro();
    }

    private HungrySingletonPro() {
    }

    public static HungrySingletonPro getInstance() {
        return instance;
    }
}
