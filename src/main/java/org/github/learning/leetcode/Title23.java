package org.github.learning.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/"></a>
 * Status: Wrong Answer
 * Runtime:
 * @author peiheng.jiang create on 2019/04/15
 */
public class Title23 {

    /**
     * 使用最小堆（优先队列）
     * 每次直接把最小值都给你了
     * 排就完事
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        SimpleMinHeap heap = new SimpleMinHeap(lists);
        ListNode head = null;
        ListNode index = null;
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            if (head == null) {
                head = tmp;
                index = head;
            } else {
                index.next = tmp;
                index = index.next;
            }
            if (tmp.next != null) {
                heap.add(tmp.next);
            }
        }
        return head;
    }

    private PriorityQueue<ListNode> initQueue(ListNode[] lists) {
        PriorityQueue<ListNode> pNodeQueue = new PriorityQueue<>(lists.length);
        pNodeQueue.addAll(Arrays.asList(lists));
        return pNodeQueue;
    }

    private static class SimpleMinHeap {

        LinkedList<ListNode> nodeList;

        public SimpleMinHeap(ListNode[] heads) {
            nodeList = new LinkedList<>();
            for (ListNode head : heads) {
                add(head);
            }
        }

        public void add(ListNode node) {
            nodeList.add(node);
            int index = nodeList.size() - 1;
            if (index == 0) {
                return;
            }
            while (index != 0) {
                int fatherIndex = (index - 1) / 2;
                ListNode indexNode = nodeList.get(index);
                ListNode fatherNode = nodeList.get(fatherIndex);
                if (fatherNode.val > indexNode.val) {
                    nodeList.set(index, fatherNode);
                    nodeList.set(fatherIndex, indexNode);
                    index = fatherIndex;
                } else {
                    break;
                }
            }
        }

        public boolean isEmpty() {
            return nodeList.isEmpty();
        }

        public ListNode poll() {
            if (nodeList.isEmpty()) {
                return null;
            }
            ListNode node = nodeList.get(0);
            nodeList.removeFirst();
            return node;
        }
    }

    public static void main(String[] args) {
        Title23 title23 = new Title23();

        ListNode head = title23.mergeKLists(new ListNode[]{
                ListNode.getList(new int[]{1, 4, 5}),
                ListNode.getList(new int[]{1, 3, 4}),
                ListNode.getList(new int[]{2, 6})
        });
        ListNode.printList(head);
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public static ListNode getList(int[] vals) {
            ListNode head = null;
            ListNode index = null;
            for (int val : vals) {
                ListNode node = new ListNode(val);
                if (head == null) {
                    head = node;
                    index = head;
                } else {
                    index.next = node;
                    index = index.next;
                }
            }
            return head;
        }

        public static void printList(ListNode head) {
            ListNode index = head;
            System.out.print(index.val);
            index = index.next;
            while (index != null) {
                System.out.print("->" + index.val);
                index = index.next;
            }
            System.out.println();
        }
    }
}
