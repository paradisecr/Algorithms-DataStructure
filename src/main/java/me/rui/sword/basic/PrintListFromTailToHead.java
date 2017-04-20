package me.rui.sword.basic;

import java.util.ArrayList;

/**
 * Created by cr on 2017/4/20.
 *
 * 从头到尾打印链表
 * 题目描述: 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null == listNode) return null;
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadInternal(list, listNode);
        return list;
    }

    private void printListFromTailToHeadInternal(ArrayList<Integer> list, ListNode listNode) {
        if (null == listNode) return;
        printListFromTailToHeadInternal(list, listNode.next);
        list.add(listNode.val);
    }


    public static class ListNode {
        public int val;
        public ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


