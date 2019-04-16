package main.java.com.shijx5514.leetcode;


import java.util.List;

/**
 * leetcode24 按对交换链表节点
 * @author shijiaxin02
 * @date 19/2/27
 */
public class SwapNodesInPairs24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode i = swapPairs(a);
        System.out.println(i.val);
        System.out.println(i.next.val);
        System.out.println(i.next.next.val);
        System.out.println(i.next.next.next.val);
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
