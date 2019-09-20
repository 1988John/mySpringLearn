package com.foo.test.leetcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * @author fooisart
 * @date 16:20 29-08-2019
 */
public class ValidParentheses20 {
    public static boolean isValid1(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        Set<Character> leftSet = new HashSet<>();
        leftSet.add('(');leftSet.add('{');leftSet.add('[');

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (leftSet.contains(c)) {
                leftStack.push(c);
            } else {
                rightStack.push(c);
                if (rightStack.size() > leftStack.size()) {
                    return false;
                }
                if (leftStack.size() == rightStack.size()) {
                    int size = leftStack.size();
                    for (int j = 0; j < size; j++) {
                        if (!match(leftStack.pop(), rightStack.get(j))) {
                            return false;
                        }
                    }
                    leftStack.clear();
                    rightStack.clear();
                }
            }
        }
        return leftStack.size() == rightStack.size();
    }
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        Set<Character> leftSet = new HashSet<>();
        leftSet.add('(');leftSet.add('{');leftSet.add('[');
        Stack<Character> leftStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (leftSet.contains(c)) {
                leftStack.push(c);
            } else {
                if (leftStack.size() == 0) return false;
                if (!match(leftStack.pop(), c)) {
                    return false;
                }
            }
        }
        return leftStack.size() == 0;
    }
    private static boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
}
