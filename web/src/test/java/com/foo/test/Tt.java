package com.foo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jiangwang
 * @date 2021-04-08 19:54
 */
public class Tt {

    private List<MyNode> searchNode(MyNode root, MyNode v) {
        List<MyNode> nodes = new ArrayList<>();
        searchNode(root, v, nodes);
        return nodes;
    }

    private boolean searchNode(MyNode root, MyNode v, List<MyNode> nodes) {
        if (root.value != v.value) {
            return true;
        }
        //开始找
        nodes.add(root);
        boolean leftResult = false;
        boolean rightResult = false;
        if (root.left != null) {
            leftResult = searchNode(root.left, v, nodes);
        }

        if (!leftResult && root.right != null){
            rightResult = searchNode(root.right, v, nodes);
        }

        if (!rightResult && root.left == null && root.right == null) { //标识 root 是一个叶子节点
            nodes.remove(nodes.size() - 1);
        }

        return leftResult || rightResult;
    }

    private List<MyNode> searchNode1(MyNode root, MyNode v) {
        List<MyNode> list = new ArrayList<>();
        Stack<MyNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            MyNode head = stack.pop();
            if (head != null) {
                //处理head
                list.add(head);
                if (head.value == v.value) {
                    return list;
                }
                if (head.left != null) {
                    stack.push(head.left);
                }else if (head.right != null) {
                    stack.push(head.right);
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
        return null;
    }
    class MyNode {
        int value;
        MyNode left;
        MyNode right;
    }
}
