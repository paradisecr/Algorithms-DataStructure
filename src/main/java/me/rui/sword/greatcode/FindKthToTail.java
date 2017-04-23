package me.rui.sword.greatcode;

/**
 * Created by cr on 2017/4/22.
 *  题目描述
 *  输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        // 注意检查几种情况：
        // 1. root == null
        // 2. k = 0;
        // 3. k < length
        if (null == head || k <= 0) return null;
        ListNode front = head;
        ListNode tail;
        for (int i =0; i< k - 1; i++) {
            if (front.next == null) return null;
            front = front.next;
        }
        tail = head;
        while (front.next != null) {
            front = front.next;
            tail = tail.next;
        }
        return tail;
    }

    public static class  ListNode {
        public int val;
        public ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


