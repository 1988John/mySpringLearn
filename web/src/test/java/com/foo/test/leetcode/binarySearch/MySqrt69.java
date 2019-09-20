package com.foo.test.leetcode.binarySearch;

/**
 * @author fooisart
 * @date 11:58 16-09-2019
 */
public class MySqrt69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {
        int low = 1;
        int high = x;
        int mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (x / mid > mid) { //mid * mid < x
                if (x / (mid + 1) < (mid + 1)) return mid; //(mid + 1) * (mid + 1) > x
                low = mid + 1;
            } else if (mid > x / mid) {
                if ((mid -1)< x / (mid - 1)) return mid-1;
                high = mid -1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
