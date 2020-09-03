package com.foo.test.leetcode.array;

import java.util.Arrays;

/**
 * @author jiangwang
 * @date 2020-08-27 19:44
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (nums1.length <= 1) {
            nums1[0] = Math.max(nums1[0], nums2[0]);
            return;
        }
        while (n >= 1) {
            if (m <= 0) { //第一个数组转移完成，直接将第二个数组完全复制到第一组
                for (; n > 0; n--) {
                    nums1[n-1] = nums2[n-1];
                }
            } else {
                if (nums1[m-1] < nums2[n-1]) {
                    nums1[m + n - 1] = nums2[n-1];
                    n --;
                } else {
                    nums1[m + n - 1] = nums1[m-1];
                    m--;
                }
            }
        }
    }
}
