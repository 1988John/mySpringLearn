package com.foo.test.leetcode.tree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author fooisart
 * @date 14:27 06-11-2019
 */
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        long l1 = 1L;
        long l2 = 8L;
        BigDecimal b1 = new BigDecimal(l1);
        BigDecimal divide = b1.divide(new BigDecimal(l2), 2, RoundingMode.HALF_UP);
        System.out.println(divide.floatValue());
        float f = (float)l1 / l2;
        System.out.println(((float)Math.round(f * 100) / 100));
    }
}
