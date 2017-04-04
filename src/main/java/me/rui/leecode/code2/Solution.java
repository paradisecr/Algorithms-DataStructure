package me.rui.leecode.code2;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2. add
        ListNode result = null;
        ListNode tail = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int c = 0;

        while(p1 != null && p2 != null) {
            int num = p1.val + p2.val + c;
            if(null == result){
                ListNode newNode  = new ListNode(num %10);
                result = newNode;
                tail = result;
            } else {
                ListNode newNode  = new ListNode(num %10);
                tail.next = newNode;
                tail = tail.next;
            }
            c = num/10;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int num = p1.val + c;
            ListNode newNode  = new ListNode(num %10);
            tail.next = newNode;
            tail = tail.next;
            p1 = p1.next;
            c = num/10;
        }
        while (p2 != null) {
            int num = p2.val + c;
            ListNode newNode  = new ListNode(num %10);
            tail.next = newNode;
            tail = tail.next;
            p2 = p2.next;
            c = num/10;
        }
        if(c !=0) {
            ListNode newNode  = new ListNode(c);
            tail.next = newNode;
        }
        return result;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}