package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * Create by peiheng.jiang on 2019/8/14
 */
public class Title25 {

    /**
     * 滑块法，分组进行reverse
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode lastGroupTail = null;
        boolean isFirstGroup = true;    // 标记，是否是第一个组
        int groupEleNum = 1;            // 当前遍历的组内，已经包含多少节点
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
                head = p1;  // 第一组，需要把head节点更新
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

    /**
     *  head和tail是一组内的头和尾节点
     *  这里主要干3件事：
     *      上一组尾节点的next设置为本组的尾节点
     *      本组内各个节点指针逆序
     *      本组头结点的next设置为下一组的头结点
     * @param head
     * @param tail
     * @param lastGroupTail
     */
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
            p2.next = p1;   // p1不是tail的时候，p2顶多为tail，由于tail不可能为空，所以p2.next也不可能出NPE
            p1 = p2;
            p2 = p3;
            p3 = p3 == null? null : p3.next;
        }
        // change head.next
        head.next = nextGroupHead;
    }


}
