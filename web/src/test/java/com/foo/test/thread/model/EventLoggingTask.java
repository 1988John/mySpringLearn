package com.foo.test.thread.model;

public class EventLoggingTask implements  Runnable{

    @Override
    public void run() {
        System.out.println("Message");
    }
}