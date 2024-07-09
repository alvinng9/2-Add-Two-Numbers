package org.example;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode slow = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int numOne = (l1 != null) ? l1.val : 0;
            int numTwo = (l2 != null) ? l2.val : 0;
            int num = numOne + numTwo + carry;
            carry = num /10;
            temp.val = num % 10;
            slow = temp;
            temp.next = new ListNode(0);
            temp = temp.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry != 0) {
            temp.val = 1;
        } else {
            slow.next = null;
        }
        return result;
    }

}
