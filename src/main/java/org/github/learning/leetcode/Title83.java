package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 26.10%
 * Create by peiheng.jiang on 2019/8/14
 */
public class Title83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p1 != null || p2 != null) {
            if (p2 == null || p1.val != p2.val) {
                p1.next = p2;
                p1 = p2;
            }
            p2 = p2 == null ? null : p2.next;
        }
        return head;
    }
}
