package com.foo.test.leetcode.rescure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fooisart
 * @date 15:52 30-08-2019
 */
public class ClimbingStairs70 {
    Map<Integer, Integer> hasComputedMap = new HashMap<>();
    public int climbStairs(int n) {
        if (hasComputedMap.containsKey(n)) {
            return hasComputedMap.get(n);
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ways = climbStairs(n - 1) + climbStairs(n - 2);
        hasComputedMap.put(n, ways);
        return ways;
    }
}
