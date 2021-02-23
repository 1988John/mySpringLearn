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

        String s1 = "ABC";
        String s2 = new String("ABC");
        String intern = s2.intern();
        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1 == s2.intern:" + (s1 == s2.intern()));
        System.out.println("s1 equal s2:" + (s1.equals(s2)));

        String str1=new StringBuilder("java").append("虚拟机").toString();//执行完这行代码后，常量池中会有"java"和"虚拟机"，但是不会有"java虚拟机"。
        System.out.println(str1.intern()==str1);
        String str2=new String("我喜欢java");  //执行完这行代码后，常量池中会有"我喜欢java"
        System.out.println(str2==str2.intern());
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
