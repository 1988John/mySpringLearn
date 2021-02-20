package com.foo.test.leetcode.link;

/**
 * @author jiangwang
 * @date 2021-02-20 09:04
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        System.out.println(head);
        ListNode newHead = reverseList(head);
        System.out.println(newHead);
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode preNode = null;
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }

        return preNode;
    }
}
