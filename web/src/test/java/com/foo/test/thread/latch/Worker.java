package com.foo.test.thread.latch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;
 
    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }
 
    @Override
    public void run() {
//        doSomeWork();
        outputScraper.add("Counted down-"+countDownLatch.getCount());
        countDownLatch.countDown();
    }
}