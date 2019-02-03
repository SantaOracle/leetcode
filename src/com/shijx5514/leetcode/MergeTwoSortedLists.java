package com.shijx5514.leetcode;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * lc21
 * @author shijiaxin02
 * @date 2019/2/3
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){ return l2;}
        if(l2 == null){ return l1;}

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Data
    @Accessors(chain = true)
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(8);
        ListNode head4 = new ListNode(11);
        ListNode head5 = new ListNode(30);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode head6 = new ListNode(1);
        ListNode head7 = new ListNode(4);
        ListNode head8 = new ListNode(7);
        ListNode head9 = new ListNode(10);
        ListNode head10 = new ListNode(13);
        head6.next = head7;
        head7.next = head8;
        head8.next = head9;
        head9.next = head10;
        MergeTwoSortedLists mergeTwoSortedLists =  new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(head1, head6);
        while (result.next!= null) {
            result = result.next;
            System.out.print(result.val + "->");
        }
    }
}
