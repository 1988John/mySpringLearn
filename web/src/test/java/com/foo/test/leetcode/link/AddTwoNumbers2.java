package com.foo.test.leetcode.link;

/**
 * @author fooisart
 * @date 2019-12-11 20:02
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodes = new ListNode((l1.val + l2.val)%10);
        ListNode first = nodes;
        int extra = (l1.val + l2.val) /10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null || extra > 0) {
            boolean l1IsNull = l1 != null;
            boolean l2IsNull = l2 != null;
            int l1V = l1IsNull ? l1.val : 0;
            int l2V = l2IsNull ? l2.val : 0;
            int val = l1V + l2V + extra;
            nodes.next = new ListNode(val % 10);
            extra = val / 10;
            nodes = nodes.next;
            l1 = l1IsNull ? l1.next : null;
            l2 = l2IsNull ? l2.next : null;
        }

        return first;
    }
    public int addTwo(int i1, int i2) {
        return i1 + i2 < 10 ? i1 + i2 : i1 + i2 - 10;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preNode = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }

        return preNode;
    }
}
