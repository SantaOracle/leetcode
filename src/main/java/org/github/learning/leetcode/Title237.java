package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100%
 *
 * @author jiangpeiheng create on 2023/2/10
 */
public class Title237 {

    /**
     * 把链表玩成数组我是没想到的……
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode next = node.next;

        while (next != null) {
            node.val = next.val;

            if (next.next == null) {
                node.next = null;
            } else {
                node = next;
            }

            next = next.next;
        }
    }
}
