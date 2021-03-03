package com.foo.test.singleton;

/**
 * @author jiangwang
 * @date 2021-02-27 08:44
 */
public class StaticInnerSingleton {
    private static class SingletonHolder {
        private static StaticInnerSingleton singleton = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
