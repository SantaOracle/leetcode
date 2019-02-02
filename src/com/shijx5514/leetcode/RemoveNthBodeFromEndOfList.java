package com.shijx5514.leetcode;


/**
 * lc19
 * @author shijiaxin
 * @date 2019/2/2
 */
public class RemoveNthBodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        if(head.next.next == null) {

        }
        ListNode head1 = reverseList(head);
        if(n == 1) {
            ListNode head4 = reverseList(head1.next);
            return head4;
        }
        ListNode head2 = head1;
        for(int i = 0 ; i<n; i++) {
            if(i == n-2) {
                head2.next = head2.next.next;
            } else {
                head2 = head2.next;
            }
        }
        ListNode head3 = reverseList(head1);
        return head3;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode n1;
        ListNode n2;
        ListNode n3;
        if(head == null) {
            return head;
        }
        n1 = head;
        n2 = head.next;
        while(n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        head.next = null;
        head = n1;
        return head;
    }

    public static void main(String[] args) {
        int n = 2;
        RemoveNthBodeFromEndOfList removeNthBodeFromEndOfList = new RemoveNthBodeFromEndOfList();
        ListNode listNode = removeNthBodeFromEndOfList.removeNthFromEnd(removeNthBodeFromEndOfList.test(), n);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }while (listNode!= null);
    }

    private ListNode test() {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        return head1;
    }

}
