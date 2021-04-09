package com.foo.test.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jiangwang
 * @date 2021-04-01 15:18
 */
public class MyNode {
    String value;
    MyNode left;
    MyNode right;

    public MyNode(String value) {
        this.value = value;
    }

    public static MyNode buildTree() {
        MyNode a = new MyNode("A");
        MyNode b = new MyNode("B");
        MyNode c = new MyNode("C");
        MyNode d = new MyNode("D");
        MyNode e = new MyNode("E");
        MyNode f = new MyNode("F");
        MyNode g = new MyNode("G");
        a.left = b;a.right = c;
        b.left = d;b.right = e;
        c.left = f;c.right = g;
        return a;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public static void main(String[] args) {
        bfsPrint();
        dfsPrint();
    }

    private static void dfsPrint() {
        System.out.print("DFS: ");
        Stack<MyNode> stack = new Stack<>();
        stack.push(buildTree());
        while (stack.size() > 0) {
            MyNode node = stack.pop();
            if (node != null) {
                System.out.print(node.value + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    private static void bfsPrint() {
        System.out.print("BFS: ");
        Queue<MyNode> queue = new ArrayDeque<>();
        queue.offer(buildTree());
        while (queue.size() >  0) {
            MyNode node = queue.poll();
            if (node != null) {
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String l = "",r = "";
        if (left != null) {
            l = ", left=" + left;
        }
        if (right != null) {
            r = ", right=" + right;
        }
        return value + '\'' +
                l +
                r +
                '}';
    }
}
