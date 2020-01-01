package com.foo.test.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fooisart
 * @date 2019-12-24 17:25
 */
public class JewelsAndStones771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (map.get(S.charAt(i)) != null) {
                count ++;
            }
        }
        return count;
    }
}
