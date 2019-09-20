package com.foo.test.leetcode.array;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 18:57 10-09-2019
 */
public class RotateArray189 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        int[] arr = new int[nums.length];
        System.arraycopy(nums, nums.length - k, arr, 0, k);
        System.arraycopy(nums, 0, arr, k, nums.length -k);
        System.arraycopy(arr, 0, nums, 0, nums.length);

    }
}
