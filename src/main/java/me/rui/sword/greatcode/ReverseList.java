package me.rui.sword.greatcode;

import me.rui.sword.util.ListNode;

/**
 * Created by cr on 2017/4/22.
 *  题目描述
 *  输入一个链表，反转链表后，输出链表的所有元素。
 *
 *  需要三个指针。
 *  应注意的情形：
 *  1. null;
 *  2. 1个元素；
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (null == head) return null;
        ListNode pre = head;
        ListNode cur = null;
        ListNode next = null;
        cur = pre.next;
        if (cur == null) {
            return pre;
        } else {
            next = cur.next;
        }
        head.next = null;
        while (true) {
            cur.next = pre;
            if (next == null) break;
            pre = cur;
            cur = next;
            next = next.next;
        }
        return cur;
    }
}
