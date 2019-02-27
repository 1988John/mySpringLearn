package com.foo.test.executor;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer>{

    private int taskNum;


    /**
     * 其实这里的firstTask是我们最初传进来要执行的任务，这里把它封装成了一个Worker。
     * 看Worker源码可以知道，其实它是Runnable接口的一个实现类。在这里，Worker充当的
     * 是一个线程的角色，它参数中有thread。那么线程的启动肯定要调用start()方法。
     * 在下方也确实找到了start()方法，启动之后，根据线程的基本知识，肯定是进入了线程
     * 的run()方法。
     */
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