package com.foo.test.leetcode.array;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 17:16 10-09-2019
 */
public class PlusOne66 {
    public static void main(String[] args) {
        int[] arr = {9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    public static int[] plusOne(int[] digits) {
        int high = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length -1) {
                high = high + 1;
            }
            int newValue = digits[i] + high;
            if (newValue < 10) {
                digits[i] = newValue;
                break;
            } else {
                if (i == 0) {
                    int[] arr = new int[digits.length + 1];
                    arr[0] = 1;
                    return arr;
                }
                digits[i] = 0;
                high = 1;
            }
        }
        return digits;
    }
}
