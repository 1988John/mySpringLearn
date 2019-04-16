package com.foo.test.bytecode;

/**
 * @author fooisart
 * @date 15:46 15-04-2019
 */
public class SyncTest {
    public void test() {
        synchronized (this) {
            System.out.println("---call test() method---");
        }
    }
}
