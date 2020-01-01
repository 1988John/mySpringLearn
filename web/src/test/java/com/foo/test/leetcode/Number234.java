package com.foo.test.leetcode;

import com.foo.test.leetcode.link.ListNode;

/**
 * @author fooisart
 * @date 21:33 19-08-2019
 */
public class Number234 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode midNode = ListNode.midNode(head);
        ListNode reverseMidNode = ListNode.reverse(midNode);
        while (reverseMidNode != null) {
            if (head.val != reverseMidNode.val) {
                return false;
            }
            head = head.next;
            reverseMidNode = reverseMidNode.next;
        }
        return true;
    }


}
