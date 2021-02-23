package com.foo.test.leetcode.sort;

import java.util.Arrays;

/**
 * @author jiangwang
 * @date 2021-02-23 12:10
 */
public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2,9,3,5,1,10};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void sortColors(int[] nums) {
        insertSort(nums);
        Arrays.sort(nums);
    }

    private static void quickSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) { //找出min
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }



    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int insertIndex = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    insertIndex = j;
                    min = nums[j];
                }
            }
            if (insertIndex != i) {
                int temp = nums[insertIndex];
                nums[insertIndex] = nums[i];
                nums[i] = temp;
            }

        }

    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) { //找出min
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
