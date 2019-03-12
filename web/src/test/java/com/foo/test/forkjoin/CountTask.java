package com.foo.test.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;//阈值

    private int start;

    private int end;

    public CountTask(int start, int end) {

        this.start = start;

        this.end = end;

    }

    @Override

    protected Integer compute() {

        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            System.out.print("start="+start + "," + "end="+end + "：");
            for (int i = start; i <= end; i++) {
                System.out.print(i+",");
                sum += i;
            }
            System.out.println();

        } else {
            System.out.println("切分==>"+"start="+start + "," + "end="+end + "：");
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start + end) / 2;

            CountTask leftTask = new CountTask(start, middle);

            CountTask rightTask = new CountTask(middle + 1, end);

            //执行子任务
            leftTask.fork();

            rightTask.fork();

            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;

        }

        return sum;

    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        //生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 10);

        //执行一个任务
        Future result = forkJoinPool.submit(task);

        System.out.println(result.get());

    }

}