package com.foo.test.leetcode.binarySearch;

/**
 * @author fooisart
 * @date 15:04 17-09-2019
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(search(arr, 3));
    }
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        while (low >= 0 && low <= high) {
            mid = (low + high) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[low] == target) return low;
            if (nums[high] == target) return high;
            if (nums[mid] > target && target > nums[low]) {
                high = mid -1;
            } else if (nums[high] > target){
                low = mid -1;
            } else {
                return -1;
            }

        }
        return -1;
    }
}
