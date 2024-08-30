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
        //create a new ListNode to return later
        ListNode current = new ListNode();
        //create a reference to the start of the ListNode
        ListNode result = current;
        //create an int to keep track of the carry if the sum goes over 9
        int carry = 0;
        //move to the next ListNode of l1 and/or l2
        while(l1 != null || l2 != null) {
            //check if the current l1 and l2 are not null
            int numOne = (l1 == null) ? 0 : l1.val;
            int numTwo = (l2 == null) ? 0 : l2.val;
            //find the sum
            current.val = (numOne + numTwo + carry) % 10;
            //find the carry
            carry = (numOne + numTwo + carry) / 10;

            //check if l1 and l2 are null to move to the next ListNode
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            //move the current ListNode to the next one
            if(l1 != null || l2 != null) {
                ListNode temp = new ListNode();
                current.next = temp;
                current = current.next;
            }
        }
        //if the carry is not 0, add another ListNode at the end
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            current.next = temp;
        }
        return result;
    }
}
