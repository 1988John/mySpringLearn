package com.foo.test.thread;

/**
 * @author fooisart
 * @date 16:17 18-11-2019
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadA b = new ThreadA();
        a.start();
        b.start();

    }
}
