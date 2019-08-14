package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * Create by peiheng.jiang on 2019/8/14
 */
public class Title25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode lastGroupTail = null;
        boolean isFirstGroup = true;
        int groupEleNum = 1;
        while (p1 != null && p2 != null) {
            if (groupEleNum < k) {
                p1 = p1.next;
                groupEleNum++;
                continue;
            }
            // reverse
            reverse(p2, p1, lastGroupTail);
            // change head node
            if (isFirstGroup) {
                head = p1;
                isFirstGroup = false;
            }
            // reinit group eleNum and ptrs
            lastGroupTail = p2;
            groupEleNum = 1;
            p1 = p2.next;
            p2 = p2.next;
        }
        return head;
    }

    private void reverse(ListNode head, ListNode tail, ListNode lastGroupTail) {
        ListNode nextGroupHead = tail.next;

        // change lastGroupTail.next
        if (lastGroupTail != null) {
            lastGroupTail.next = tail;
        }
        // loop for reverse
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p1 != tail) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3 == null? null : p3.next;
        }
        // change head.next
        head.next = nextGroupHead;
    }


}
