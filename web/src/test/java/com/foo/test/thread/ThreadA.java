package com.foo.test.thread;

/**
 * @author fooisart
 * @date 16:16 18-11-2019
 */
public class ThreadA extends Thread {
    private int num = 0;

    @Override
    public void run() {
        num ++;
    }

    public int getNum() {
        return num;
    }
}
