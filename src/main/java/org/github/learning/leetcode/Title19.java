package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * Create by peiheng.jiang on 2019/8/12
 */
public class Title19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        int indexInterval = 0;
        ListNode ptr1 = head;
        ListNode ptr2 = head;   // node to remove
        ListNode ptr2Pre = null;
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            if (indexInterval < n) {
                indexInterval++;
            } else {
                ptr2Pre = ptr2;
                ptr2 = ptr2.next;
            }
        }
        if (ptr2 == head) {
            return head.next;
        } else {
            ptr2Pre.next = ptr2.next;
        }
        return head;
    }
}
