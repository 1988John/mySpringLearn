package com.foo.test.leetcode.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangwang
 * @date 2021-03-07 18:15
 */
public class AddStrings415 {
    public static void main(String[] args) {
        System.out.println(addStrings("9", "99"));
    }
    public static String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }
        int[] arr1 = new int[num1.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            arr1[i] = num1.charAt(i) - '0';
        }
        int[] arr2 = new int[num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            arr2[i] = num2.charAt(i) - '0';
        }
        int len = Integer.max(arr1.length, arr2.length);
        int[] arr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            int n1 = 0,n2 = 0, result, index;
            if (i <= arr1.length -1) {
                n1 = arr1[arr1.length - 1 -i];
            }
            if (i <= arr2.length -1) {
                n2 = arr2[arr2.length - 1 -i];
            }
            index = arr.length - 1 - i;

            result= n1 + n2 + arr[index];

            if (result >= 10) {
                arr[index] = result % 10;
                arr[index - 1] = 1;
            } else {
                arr[index] = result;
            }

        }
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("")).replaceFirst("^0*", "");
    }
}
