package com.foo.test.timer.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayDequeDemo {
    public static void main(String[] args) throws Exception {

        BlockingQueue<DelayTask> queue = new DelayQueue<>();

        DelayTask delayTask = new DelayTask(1000 * 5L);

        queue.put(delayTask);

        while (queue.size()>0){
            queue.take();
        }
    }
}