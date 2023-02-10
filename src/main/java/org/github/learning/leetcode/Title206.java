package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100%
 *
 * @author jiangpeiheng create on 2023/2/9
 */
public class Title206 {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = Objects.nonNull(current) ?
                current.next : null;
        ListNode prew = null;

        while (Objects.nonNull(current)) {
            current.next = prew;

            if (Objects.isNull(next)) {
                head = current;
            }

            prew = current;
            current = next;
            if (Objects.nonNull(next)) {
                next = next.next;
            }
        }

        return head;
    }
}
