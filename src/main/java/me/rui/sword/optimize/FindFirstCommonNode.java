package me.rui.sword.optimize;

import me.rui.sword.util.ListNode;

/**
 * Created by cr on 2017/4/23.
 *
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1 || pHead2 == null) return null;
        int count1 = 0;
        int count2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            count1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            count2++;
            p2 = p2.next;
        }
        if (count1 < count2) {
            ListNode tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        int count = count1 - count2;
        p1 = pHead1;
        p2 = pHead2;
        while (count>0) {
            p1 = p1.next;
            count--;
        }
        while (p1 !=null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
