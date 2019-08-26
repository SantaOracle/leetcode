package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.DoubleSideListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/"></a>
 * Status:  AC
 * Runtime: 60 ms, faster than 73.52%
 * Create by peiheng.jiang on 2019/8/26
 */
public class Title146 {

    /**
     * 本题要提交的时候，请把{@link DoubleSideListNode}类也一起拷过去
     * 采用HashMap + 双向链表实现
     */
    public static class LRUCache {

        private Map<Integer, DoubleSideListNode> map;
        private int capacity;
        private int size;
        private DoubleSideListNode head;
        private DoubleSideListNode tail;

        public LRUCache(int capacity) {
            this.map = new HashMap<>(capacity * 2);
            this.size = 0;
            this.capacity = capacity;
            head = new DoubleSideListNode(-1, -1);
            tail = new DoubleSideListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DoubleSideListNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            DoubleSideListNode node = map.get(key);
            if (node == null) {
                node = new DoubleSideListNode(key, value);
                size++;
            } else {
                node.val = value;
            }
            moveToHead(node);
            this.map.put(key, node);
            if (size > capacity) {
                removeTail();
                size--;
            }
        }

        private void moveToHead(DoubleSideListNode node) {
            removeNode(node);

            DoubleSideListNode headNode = head.next;
            head.next = node;
            headNode.prev = node;
            node.prev = head;
            node.next = headNode;
        }

        private void removeTail() {
            DoubleSideListNode tailNode = tail.prev;
            if (tailNode == head) {
                return;
            }
            removeNode(tailNode);
            this.map.remove(tailNode.key);
        }

        private void removeNode(DoubleSideListNode node) {
            if (node == head || node == tail) {
                return;
            }
            DoubleSideListNode prev = node.prev;
            DoubleSideListNode next = node.next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
        }

        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);
            cache.put(2, 1);
            cache.put(1, 1);
            cache.put(2, 3);
            cache.put(4, 1);
            System.out.println(cache.get(1));
            System.out.println(cache.get(2));
        }
    }
}
