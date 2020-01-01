package com.foo.test.classics;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 18:32 19-11-2019
 */
public class KmpTest {
    public static void main(String[] args) {
        String str = "abababzabababa";
        int[] arr = calculateMaxMatchLengths(str);
        System.out.println(Arrays.toString(arr));
    }
    // 构造 pattern 的最大匹配数表
    public static int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern.charAt(i) == pattern.charAt(maxLength)) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }
}
