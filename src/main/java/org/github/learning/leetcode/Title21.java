package org.github.learning.leetcode;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/"></a>
 * Status: AC
 * Runtime: 7 ms, faster than 67.14%
 * @author peiheng.jiang create on 2019/1/30
 */
public class Title21 {

    /**
     * My solution
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode index = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (index == null) {
                    index = new ListNode(l2.val);
                    head = index;
                } else {
                    index.next = new ListNode(l2.val);
                    index = index.next;
                }
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                if (index == null) {
                    index = new ListNode(l1.val);
                    head = index;
                } else {
                    index.next = new ListNode(l1.val);
                    index = index.next;
                }
                l1 = l1.next;
                continue;
            }
            if (l1.val <= l2.val) {
                if (index == null) {
                    index = new ListNode(l1.val);
                    head = index;
                } else {
                    index.next = new ListNode(l1.val);
                    index = index.next;
                }
                l1 = l1.next;
            } else {
                if (index == null) {
                    index = new ListNode(l2.val);
                    head = index;
                } else {
                    index.next = new ListNode(l2.val);
                    index = index.next;
                }
                l2 = l2.next;
            }
        }
        return head;
    }

    /**
     * Best solution
     * Runtime: 6 ms
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        //Init 2 pointers
        ListNode p1 = l1, p2 = l2;
        //Walk them along the lists, comparing at each value

        while (p1 != null || p2 != null) {

            //If p1 is null => append p2, increment
            if (p1 == null) {
                prev.next = p2;
                p2 = p2.next;
                prev = prev.next;
                //If p2 is null => append p1, increment
            } else if (p2 == null) {
                prev.next = p1;
                p1 = p1.next;
                prev = prev.next;
                //Else if p1 is >= p2 (arbitrary tie break), append p2 to running list, increment
            } else if ( p1.val >= p2.val ) {
                prev.next = p2;
                p2 = p2.next;
                prev = prev.next;
                //Otherwise append p1, increment
            } else {
                prev.next = p1;
                p1 = p1.next;
                prev = prev.next;
            }
        }

        return dummy.next;
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
}
