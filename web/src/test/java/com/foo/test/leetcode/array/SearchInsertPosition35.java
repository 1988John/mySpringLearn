package com.foo.test.leetcode.array;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 21:41 10-09-2019
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        System.out.println(15%14);
    }
    public static int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i == nums.length -1 || (nums[i] < target && target < nums[i + 1])) {
                return i + 1;
            }
        }
        return nums.length;
    }
}
