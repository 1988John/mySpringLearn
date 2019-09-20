package com.foo.test.leetcode.binarySearch;

/**
 * @author fooisart
 * @date 11:35 16-09-2019
 */
public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid -1)) {
                    return mid;
                } else {
                    high = mid -1;
                }
            } else {
                low = mid + 1;
            }
        }
        return 1;

    }
    public boolean isBadVersion(int version) {
        return false;
    }

}
