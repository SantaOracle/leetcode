package com.hc.leetcode;

public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode first = l1;
        ListNode second = l2;
        ListNode result = null;
        ListNode head = null;
        boolean carry = false;
        while(first != null && second != null){
            int fn = first.val;
            int sn = second.val;
            int r = fn + sn;
            if(carry){
                r++;
                carry = false;
            }
            if(r > 9){
                carry = true;
                r = r % 10;
            }
            if(result == null){
                result = new ListNode(r);
                head = result;
            }else{
                result.next = new ListNode(r);
                result = result.next;
            }

            first = first.next;
            second = second.next;
        }

        while(second != null){
            if(carry){
                second.val ++;
                carry = false;
            }
            if(second.val > 9){
                carry = true;
                second.val = second.val % 10;
            }
            result.next = second;
            result = result.next;
            second = second.next;
        }

        while(first != null){
            if(carry){
                first.val ++;
                carry = false;
            }
            if(first.val > 9){
                carry = true;
                first.val = first.val % 10;
            }
            result.next = first;
            result = result.next;
            first = first.next;
        }

        if(carry){
            result.next = new ListNode(1);
        }

        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
