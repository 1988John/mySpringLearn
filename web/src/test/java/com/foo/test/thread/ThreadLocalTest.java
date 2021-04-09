package com.foo.test.thread;

import com.foo.test.thread.model.ThreadUser;

/**
 * @author jiangwang
 * @date 2021-02-25 21:44
 */
public class ThreadLocalTest {
    static ThreadLocal<Integer> intThreadLocal = new ThreadLocal<>();
    static ThreadLocal<ThreadUser> userThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> strThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        intThreadLocal.set(90);
        System.out.println(intThreadLocal.get());

        ThreadUser user = new ThreadUser("foo", 28);
        userThreadLocal.set(user);
        System.out.println(userThreadLocal.get());
    }
}
