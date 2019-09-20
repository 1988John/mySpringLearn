package com.foo.test.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fooisart
 * @date 16:34 02-09-2019
 */
public class RelativeSortArray1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ints = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Map.put(arr2[i], i);
        }

        //找出不在arr2中的值
        List<Integer> outList = new ArrayList<>();
        Map<Integer, List<Integer>> arr1Map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr2Map.get(arr1[i]) == null) {
                outList.add(arr1[i]);
            } else {
                List<Integer> timesList = arr1Map.get(arr1[i]);
                if (timesList == null) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr1[i]);
                    arr1Map.put(arr1[i], temp);
                } else {
                    timesList.add(arr1[i]);
                }
            }
        }
        outList.sort(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();
        for (int item : arr2) {
            result.addAll(arr1Map.get(item));
        }
        result.addAll(outList);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
