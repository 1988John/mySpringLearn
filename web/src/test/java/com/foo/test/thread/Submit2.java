package com.foo.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ThreadPoolExecutor#submit(Runnable task, T result)
 * Created by yulinfeng on 6/17/17.
 */
public class Submit2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Data data = new Data();
        Future<Data> future = executor.submit(new Task(data), data);
        System.out.println(future.get().getName());
    }
}

class Data {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Task implements Runnable {
    Data data;

    public Task(Data data) {
        this.data = data;
    }
    public void run() {
        System.out.println("This is ThreadPoolExetor#submit(Runnable task, T result) method.");
        data.setName("kevin");
    }
}