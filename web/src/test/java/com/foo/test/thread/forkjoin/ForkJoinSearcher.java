package com.foo.test.thread.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * @author Fooisart
 * Created on 08-01-2019
 */
public class ForkJoinSearcher extends RecursiveTask<Boolean> {
    int[] arr;
    int searchableElement;
    ForkJoinSearcher(int[] arr,int search)
    {
        this.arr = arr;
        this.searchableElement=search;
    }
    @Override
    protected Boolean compute() {
        int mid = arr.length/2;
        System.out.println(Thread.currentThread().getName()
                + " says : After splliting the arry length is :: "+ arr.length + " Midpoint is " + mid);
        if(arr[mid] == searchableElement)
        {
            System.out.println(" FOUND !!!!!!!!!");
            return true;
        }
        else if(mid==1 || mid == arr.length)
        {
            System.out.println("NOT FOUND !!!!!!!!!");
            return false;
        }
        else if(searchableElement < arr[mid])
        {
            System.out.println(Thread.currentThread().getName() + " says :: Doing Left-search");
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            ForkJoinSearcher forkTask = new ForkJoinSearcher(left,searchableElement);
            forkTask.fork();
            return forkTask.join();
        }
        else if(searchableElement > arr[mid])
        {
            System.out.println(Thread.currentThread().getName() + " says :: Doing Right-search");
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            ForkJoinSearcher forkTask = new ForkJoinSearcher(right,searchableElement);
            forkTask.fork();
            return forkTask.join();
        }
        return false;
    }
}
