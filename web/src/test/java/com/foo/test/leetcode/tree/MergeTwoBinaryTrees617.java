package com.foo.test.leetcode.tree;

/**
 * @author fooisart
 * @date 18:06 04-11-2019
 */
public class MergeTwoBinaryTrees617 {
    static int count = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2; node1.right = node3;
        node2.left = node4 ; node3.right = node5;

        preOrder(node1);
        System.out.println(count);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        if (node.left != null || node.right != null) {
            count ++;
        }
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void preOrderAddVal(TreeNode t1, TreeNode t2, TreeNode t) {
        if (t1 == null && t2 == null) return;


    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return null;
    }

}
