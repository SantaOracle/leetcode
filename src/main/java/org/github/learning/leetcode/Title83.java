package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"></a>
 * Status:  AC
 * Runtime: 2 ms, faster than 6.22%
 * Create by peiheng.jiang on 2019/8/14
 */
public class Title83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode prev = head;
        ListNode curt = head;
        while (curt != null) {
            if (set.contains(curt.val)) {
                prev.next = curt.next;
                curt = curt.next;
            } else {
                set.add(curt.val);
                if (prev != curt) {
                    prev = curt;
                }
                curt = curt.next;
            }
        }
        return head;
    }
}
