package com.foo.test.bit;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiangwang3
 * @date 2018/8/29.
 */
public class BitTest {
//    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
//    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {
//        System.out.println("-1 << 29==>"+Integer.toBinaryString(iValue29));
//
//        int iValue5 = -1 << 5;
//        System.out.println("-1 << 5==>"+Integer.toBinaryString(iValue5));

        System.out.println("1 << 29==>"+Integer.toBinaryString(1 << 29));

        int cap = (1 << 29) - 1;
        System.out.println("cap=    =>"+Integer.toBinaryString(cap));

        System.out.println("-1==     >"+Integer.toBinaryString(-1));

        int RUNNING = -1 << 29;
        System.out.println("RUNNING==>"+Integer.toBinaryString(RUNNING));
        int ctl = RUNNING | 0;
        System.out.println("ctl==>"+Integer.toBinaryString(ctl));
        int workers = ctl & cap;
        System.out.println("ctl & cap==>"+Integer.toBinaryString(workers));

    }
}
