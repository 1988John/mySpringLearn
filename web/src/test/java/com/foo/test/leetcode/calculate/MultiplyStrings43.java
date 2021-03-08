package com.foo.test.leetcode.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangwang
 * @date 2021-03-07 15:46
 */
public class MultiplyStrings43 {
    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1,n2,index, result, p1, p2;
        int[] array = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            n1 = num1.charAt(i) - '0';
            p1 = num1.length() - 1 - i;
            for (int j = num2.length() - 1; j >= 0; j--) {
                n2 = num2.charAt(j) - '0';
                p2 = num2.length() - 1 - j;
                index = num1.length() + num2.length() - p1 - p2 - 1;
                result = n1 * n2 + array[index];
                if (result >= 10) {
                    array[index] = result % 10;
                    array[index - 1] += result / 10;
                } else {
                    array[index] = result;
                }
            }
        }
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""))
                .replaceFirst("^0*", "");
    }
}
