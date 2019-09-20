package com.foo.test.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fooisart
 * @date 18:45 03-09-2019
 */
public class IntersectionOfTwoArrays349 {
    /**
     *  Intersection of Two Arrays
     *
     * @author fooisart
     * @date 18:51 2019/9/3
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            map1.put(i, 0);
        }
        for (int i : nums2) {
            if (map1.get(i) != null) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    /**
     *  Intersection of Two Arrays II
     *
     * @author fooisart
     * @date 18:50 2019/9/3
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = array2Map(nums1);
        Map<Integer, Integer> map2 = array2Map(nums2);
        List<Integer> result = new ArrayList<>();
        if (nums1.length < nums2.length) {
            for (int i : nums1) {
                Integer r = map2.get(i);
                if (r != null) {

                }
            }
        } else {

        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Map<Integer, Integer> array2Map(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer r = map.get(i);
            if (r != null) {
                map.put(i, r + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

}
