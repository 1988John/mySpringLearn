package com.foo.test.thread;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwang
 * @date 2021-03-02 16:21
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        Vector v = new Vector();
        v.add(1, 2);
    }
}
