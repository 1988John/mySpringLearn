package com.foo.test.leetcode.sort;

import java.util.PriorityQueue;

/**
 * @author jiangwang
 * @date 2021-02-26 19:07
 */
public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
