package com.foo.test.leetcode.greedy;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 19:22 02-12-2019
 */
public class AssignCookies455 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {3};
        int count = findContentChildren(g, s);
        System.out.println(count);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            for (; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    count ++;
                    j++;
                    break;
                }
            }
        }
        return count;
    }
}
