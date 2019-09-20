package com.foo.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fooisart
 * @date 16:00 22-08-2019
 */
public class Num15 {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0,0,0};
        int[] nums3 = {1,1,-2};
        int[] nums4 = {3,0,-2,-1,1,2};
        int[] nums5 = {1,2,-2,-1};
        int[] nums = {3,0,-2,-1,1,2};
        int[] nums6 = {-2,-3,0,0,-2};
        int[] nums7 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum4(nums4);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i+1; j < nums.length; j++) {
                int key = -nums[i] - nums[j];

                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                if(numsMap.containsKey(key) && numsMap.get(key) > j) {
                    result.add(Arrays.asList(nums[i], nums[j], key));
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int first = 0,second, third;
        while (first < nums.length -2) {
            second = first + 1;
            third = nums.length -1;

            while (second < third) {
                if (nums[first] + nums[second] +  nums[third] < 0) {
                    ++ second;
                } else if (nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);temp.add(nums[second]);temp.add(nums[third]);
                    result.add(temp);
                    while (nums[second] == nums[++second] && second < third);
                    while (nums[third] == nums[--third] && third > second);
                } else {
                    --third;
                }
            }
            while (nums[first] == nums[++first] && first < third);
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> minusInts = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> plusInts = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                minusInts.add(num);
            } else if (num == 0) {
                zeros.add(num);
            } else {
                plusInts.add(num);
            }
        }
        //1， 0 + 正数 + 负数 || 0 + 0 + 0
        if (zeros.size() > 0) {
            for (Integer minusInt : minusInts) {
                if (plusInts.contains(-minusInt)) {
                    addItem(result, 0, minusInt, -minusInt);
                }
            }
            if (zeros.size() >= 3) {
                addItem(result, 0, 0, 0);
            }
        }
        //2, 正数 + 正数 + 负数
        sum(result, plusInts, minusInts);
        //3, 负数 + 负数 + 正数
        sum(result, minusInts, plusInts);

        return result;
    }

    private static void sum(List<List<Integer>> result, List<Integer> firstInts, List<Integer> secondInts) {
        if (firstInts.size() > 1) {
            for (int i = 0; i <= firstInts.size()-2; i++) {
                for (int j = i+1; j <= firstInts.size()-1; j++) {
                    int minus = firstInts.get(i) + firstInts.get(j);
                    if (secondInts.contains(-minus)) {
                        addItem(result, firstInts.get(i), firstInts.get(j), -minus);
                    }
                }
            }
        }
    }

    private static void addItem(List<List<Integer>> result, int first, int second, int third) {
        List<Integer> temp = new ArrayList<>();
        temp.add(first);
        temp.add(second);
        temp.add(third);
        Collections.sort(temp);
        if (!result.contains(temp)) {
            result.add(temp);
        }
    }



    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int v = nums[i] + nums[l] + nums[r];
                    if (v == 0) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (v < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
