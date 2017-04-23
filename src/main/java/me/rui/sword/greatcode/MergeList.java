package me.rui.sword.greatcode;

import me.rui.sword.util.ListNode;

/**
 * Created by cr on 2017/4/22.
 *  题目描述
 *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode cur = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode tmp;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tmp = p1;
                p1 = p1.next;
            } else {
                tmp = p2;
                p2 = p2.next;
            }
            if (head == null) {
                head = tmp;
                cur = tmp;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
        }
        while (p1 != null) {
            tmp = p1;
            p1 = p1.next;
            if (head == null) {
                head = tmp;
                cur = tmp;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
        }
        while (p2 != null) {
            tmp = p2;
            p2 = p2.next;
            if (head == null) {
                head = tmp;
                cur = tmp;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
        }
        return head;
    }
}
