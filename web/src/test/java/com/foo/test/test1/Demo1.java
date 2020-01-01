package com.foo.test.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author fooisart
 * @date 09:20 27-10-2019
 */
public class Demo1 {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4};
        int[] arr2 = Arrays.copyOf(arr1, 6);

        arr2[4] = 5;
        arr2[5] = 6;
        Random random = new Random();
        random.nextInt(10);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        List<Integer> list  = new ArrayList<>();
        list.size();



    }
}
