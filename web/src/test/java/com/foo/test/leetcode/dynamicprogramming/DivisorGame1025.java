package com.foo.test.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fooisart
 * @date 2019-12-11 19:32
 */
public class DivisorGame1025 {
    public boolean divisorGame(int N) {
        boolean[] arr = new boolean[N + 1];
        arr[1] = false;
        arr[2] = true;
        arr[3] = false;
        Set<Integer> successSet = new HashSet<>();
        successSet.add(2);
        for (int i=4;i<=N;i++) {

        }
        return false;
    }
}
