package com.foo.test.leetcode.array;

/**
 * @author fooisart
 * @date 17:46 10-09-2019
 */
public class ValidMountainArray941 {
    public static void main(String[] args) {
        int[] arr = {3,5,5};
        System.out.println(validMountainArray(arr));
    }
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        boolean top = false;
        for (int i = 0; i < A.length; i++) {
            if (!top) {
                if (i == A.length -1) return false;
                if (A[i] > A[i + 1]) {
                    top = true;
                    if (i == 0) return false;
                }
            } else {
                if (A[i-1] <= A[i]) {
                    return false;
                }
            }
        }

        return top;
    }
}
