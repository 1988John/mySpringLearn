package com.foo.test.leetcode.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangwang
 * @date 2021-03-07 19:21
 */
public class AddToArrayFormOfInteger989 {
    public static void main(String[] args) {
        int[] arry = {1,2,3,4};
        System.out.println(addToArrayForm(arry, 34));
    }
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0,result;
        String kstr = String.valueOf(K);
        int len = Integer.max(A.length, kstr.length());
        int[] arr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int a = 0, k = 0;
            if (A.length - 1 - i >= 0) {
                a = A[A.length - 1 - i];
            }
            if (kstr.length() - 1 - i >= 0) {
                k = kstr.charAt(kstr.length() - 1 - i) - '0';
            }
            result  = a + k + carry;
            if (result > 9) {
                arr[arr.length - 1 - i] = result % 10;
                arr[arr.length - 1 - i - 1] = 1;
                carry = 1;
            } else {
                arr[arr.length - 1 - i] = result;
                carry = 0;
            }
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (arr[0] == 0) {
            list.remove(0);
        }
        return list;
    }
}
