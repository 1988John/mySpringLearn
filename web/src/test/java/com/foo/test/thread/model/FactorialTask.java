package com.foo.test.thread.model;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public Integer call() {
        int fact = 1;
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }
        return fact;
    }
}