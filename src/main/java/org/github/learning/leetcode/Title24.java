package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * create by peiheng.jiang on 2019/7/24
 */
public class Title24 {

    /**
     * Recrusive solution
     * @param head
     * @return
     */
    public ListNode swapPairsR(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsR(next.next);
        next.next = head;
        return next;
    }

    /**
     * My Solution
     * Non recrusive
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return doSwap(head);
    }

    private ListNode doSwap(ListNode head) {
        ListNode root = head.next;

        ListNode lastGroupTail = null;
        ListNode curtGroupHead = head;

        while (curtGroupHead != null) {
            ListNode nextGroupHead = getNextGroupHead(curtGroupHead);
            ListNode curtGroupTail = curtGroupHead.next;

            if (lastGroupTail != null) {
                lastGroupTail.next = curtGroupTail == null ? curtGroupHead : curtGroupTail;
            }

            if (curtGroupTail != null) {
                curtGroupTail.next = curtGroupHead;
            }

            curtGroupHead.next = nextGroupHead;
            lastGroupTail = curtGroupHead;
            curtGroupHead = nextGroupHead;
        }

        return root;
    }

    private ListNode getNextGroupHead(ListNode curtGroupHead) {
        if (curtGroupHead == null
                || curtGroupHead.next == null
                || curtGroupHead.next.next == null) {
            return null;
        }
        return curtGroupHead.next.next;
    }
}
