package com.foo.test.base;

/**
 * @author fooisart
 * @date 11:11 09-04-2019
 */
public class VolatileTest {
    volatile long vl = 0L;

    public long getVl() {
        return vl;
    }

    public void setVl(long vl) {
        this.vl = vl;
    }

    public void increment(){
        int i = 1;
        vl++;
        i = 2;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
    }
}
