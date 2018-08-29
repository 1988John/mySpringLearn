package com.foo.test.thread.executor;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer>{

    private int taskNum;

    public MyTask(int taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        Random random = new Random();
        System.out.println("This is `call()` method of Task #" + taskNum);
        Thread.sleep(random.nextInt(500));
        return taskNum;
    }

}