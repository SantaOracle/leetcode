package main.java.com.shijx5514.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 对k个链表合并成一个链表并排序
 * @author shijiaxin02
 * @date 2019/02/20
 */
public class MergekSortedLists23 {
    ListNode currentNode = new ListNode(0);
    ListNode firstNode = new ListNode(0);
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode minListNode = new ListNode(Integer.MAX_VALUE);
        for(ListNode listNode : lists) {
            if(listNode.val < minListNode.val) {
                minListNode = listNode;
            }
        }
        if(currentNode.val == 0) {
            firstNode = minListNode;
            currentNode = minListNode;
        } else {
            currentNode.next = minListNode;
            currentNode = minListNode;
        }
        ListNode[] listList = new ListNode[lists.length];
        for(int i=0 ; i < lists.length ; i++) {
            if(lists[i] != currentNode) {
                listList[i] = lists[i];
            } else {
                listList[i] = currentNode;
            }
        }
        mergeKLists(listList);
        return firstNode;
    }

    public class ListNode {
       int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //best soluation
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(0);
        ListNode p = head;

        for (int i = 0;i < lists.length;++i) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                heap.add(node.next);
            }
        }

        return head.next;
    }
}
