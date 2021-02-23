package com.foo.test.leetcode.search;

/**
 * @author jiangwang
 * @date 2021-02-22 12:20
 */
public class BinarySearch704 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(search(nums, 5));
    }
    public static int search(int[] nums, int target) {
//        if (nums.length == 0) return -1;

        int min = 0,mid,max = nums.length -1;
        while (min <= max) {
            mid = (min + max) >> 1;
            if (nums[mid] < target) {
                min = mid + 1;
            } else if (nums[mid] > target) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
