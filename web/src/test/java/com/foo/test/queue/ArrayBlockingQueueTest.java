package com.foo.test.queue;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Fooisart
 * @date 20:09 06-03-2019
 */
public class ArrayBlockingQueueTest extends ArrayBlockingQueue<Integer>{

    public ArrayBlockingQueueTest(int capacity) {
        super(capacity);
    }

    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.take();
        queue.put(5);
        queue.take();
        System.out.println();
    }

}
