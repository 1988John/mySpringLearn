package com.foo.test.leetcode.link;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.foo.test.leetcode.link.ListNode;

/**
 * @author fooisart
 * @date 11:39 30-08-2019
 */
public class MergeKSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        List<Integer> intsList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                intsList.add(head.val);
                head = head.next;
            }
        }
        if (intsList.size() <= 0) {
            return null;
        }
        intsList.sort(Comparator.naturalOrder());
        ListNode tempResult = new ListNode(intsList.get(0));
        ListNode result = tempResult;
        for (int i = 1; i < intsList.size(); i++) {
            tempResult.next = new ListNode(intsList.get(i));
            tempResult = tempResult.next;
        }
        return result;
    }
}
