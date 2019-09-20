package com.foo.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fooisart
 * @date 18:05 30-08-2019
 */
public class Num18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int first,second, third;
        int pom = 0;
        while (pom < nums.length -3) {
            first = pom + 1;
            while (first < nums.length -2) {
                second = first + 1;
                third = nums.length -1;

                while (second < third) {
                    if (nums[first] + nums[second] +  nums[third] < target - nums[pom]) {
                        ++ second;
                    } else if (nums[first] + nums[second] + nums[third] == target - nums[pom]){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[pom]);temp.add(nums[first]);temp.add(nums[second]);temp.add(nums[third]);
                        result.add(temp);
                        while (nums[second] == nums[++second] && second < third);
                        while (nums[third] == nums[--third] && third > second);
                    } else {
                        --third;
                    }
                }
                while (nums[first] == nums[++first] && first < third);
            }
            while (nums[pom] == nums[++pom] && pom < first);
        }

        return result;
    }
}
