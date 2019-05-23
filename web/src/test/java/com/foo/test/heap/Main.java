package com.foo.test.heap;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 16:49 22-05-2019
 */
public class Main {
    public static void main(String[] args) {
        MyMaxPriorityQueue queue = new MyMaxPriorityQueue();
        queue.add(3);
        queue.add(5);
        queue.add(31);
        queue.add(1);
        System.out.println(Arrays.toString(queue.elements()));
        System.out.println("max=" + queue.extractMax());
        System.out.println(Arrays.toString(queue.elements()));
    }
}
