package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/12
 **/
public class T_2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(8);
        T_2 t_2 = new T_2();
        ListNode listNode = t_2.addTwoNumbers(l1, l2);
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;
        boolean carry = false;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null) {
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            int val = x + y;
            if (carry) {
                val++;
            }
            carry = (val / 10 > 0);
            if (carry) {
                val = val % 10;
            }

            ListNode cur = new ListNode(val);
            if (head == null) {
                head = cur;
            }
            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (carry) {
            pre.next = new ListNode(1);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode of(int... nums) {
        ListNode head = null;
        ListNode pre = null;
        for (int num : nums) {
            ListNode cur = new ListNode(num);
            if (head == null) {
                head = cur;
            }
            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;
        }
        return head;
    }
}
