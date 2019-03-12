package com.foo.test.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ExerciseSort {

    //数据源
    static int num[] = new int[100];
    static {
        Random r = new Random();
        for(int i = 0 ; i < 100 ; i++){
            num[i] = r.nextInt(100);
        }
    }

    public static void main(String[] args) {
        CounterSort counter = new CounterSort(num);
        //使用单例
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long st = System.currentTimeMillis();
        //启动并行任务
        pool.invoke(counter);
        System.out.println((System.currentTimeMillis() - st));
        Arrays.stream(counter.join()).forEach(System.out::println);
    }
}

class CounterSort extends RecursiveTask<int[]> {

    //最小拆分单位：每个小数组length = 10
    public static final int THRESHOLD = 10;
    //待排序数组
    private int[] values;

    public CounterSort(int [] values){
        this.values = values;
    }

    @Override
    protected int[] compute() {
        if(values.length < THRESHOLD ){
            int[] result = new int[values.length];
            //1.单数组排序
            result = Arrays.stream(values).sorted().toArray();
            return result;
        }else {
            int mid = values.length / 2;
            CounterSort first = new CounterSort(Arrays.copyOfRange(values,0,mid));
            first.fork();
            CounterSort second = new CounterSort(Arrays.copyOfRange(values,mid,values.length));
            int[] secondResult = second.compute();
            int[] firstResult = first.join();
            //两个数组混合排序
            int[] combineRsult = combineIntArray(firstResult,secondResult);
            return combineRsult;
        }
    }
    private int[] combineIntArray(int[] a1,int[] a2){
        int result[] = new int[a1.length + a2.length];
        int a1Len = a1.length;
        int a2Len = a2.length;
        int destLen = result.length;

        for(int index = 0 , a1Index = 0 , a2Index = 0 ; index < destLen ; index++) {
            int value1 = a1Index >= a1Len?Integer.MAX_VALUE:a1[a1Index];
            int value2 = a2Index >= a2Len?Integer.MAX_VALUE:a2[a2Index];
            if(value1 < value2) {
                a1Index++;
                result[index] = value1;
            }
            else {
                a2Index++;
                result[index] = value2;
            }
        }
        return result;
    }
}