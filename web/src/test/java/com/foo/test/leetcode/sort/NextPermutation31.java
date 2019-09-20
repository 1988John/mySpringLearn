package com.foo.test.leetcode.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author fooisart
 * @date 18:06 04-09-2019
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            for (int j = i - 1; j < nums.length; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    return;
                }
            }
        }
        reverserArray(nums);
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverserArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
