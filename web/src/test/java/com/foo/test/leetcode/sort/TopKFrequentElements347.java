package com.foo.test.leetcode.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author jiangwang
 * @date 2021-02-26 19:23
 */
public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer times = map.get(num);
            times = times == null  ? 0 : times;
            map.put(num, ++ times);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }

}
