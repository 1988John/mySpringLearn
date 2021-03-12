package com.foo.test.leetcode.string;

import java.util.HashMap;

/**
 * @author jiangwang
 * @date 2021-03-12 14:10
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            Integer index = map.get(c);
            if (index == null) { //无重复
                map.put(c, r);
                r ++;
                if (r - l > maxLen) {
                    maxLen = r - l;
                }
            } else {
                for (int i = l; i <= index; i++) {
                    map.remove(s.charAt(i));
                }
                l = index + 1;
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);
            int tempLen = 1;
            map.put(c, 1);
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                Integer times = map.get(c2);
                if (times == null) { //无重复
                    map.put(c2, 1);
                    tempLen ++;
                } else {
                    break;
                }
            }
            if (tempLen > maxLen) {
                maxLen = tempLen;
            }
            map.clear();
        }
        return maxLen;
    }
}
