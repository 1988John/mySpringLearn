package com.foo.test.bytecode;

/**
 * @author fooisart
 * @date 13:54 09-04-2019
 */
public class Test {
    volatile static int iv = 1;
    public static void main(String[] args) {
        int a = iv;
        int b = a + 1;
    }
}
