package me.rui.sword.greatidea;

import me.rui.sword.util.RandomListNode;

import java.util.HashMap;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：
 * 先复制节点，再重新链接random。
 * 重点在于Random的链接，一种方法是用Hash保存引用映射；
 * 另一种更简单的方法是直接将新节点复制到源节点后，再拆分，可以避免使用辅助空间。
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (null == pHead) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // 1. 遍历next并创建所有节点，保存节点映射；
        RandomListNode attachHead = new RandomListNode(-1);
        traverseCreate(map, pHead, attachHead);
        // 2. 遍历random，根据节点映射关系建立random指针；
        traverseRandomLink(map, pHead, attachHead.next);
        return attachHead.next;
    }

    private void traverseCreate(HashMap<RandomListNode, RandomListNode> map, RandomListNode srcNode, RandomListNode dstParent) {
        if (srcNode == null) return;
        RandomListNode newNode = new RandomListNode(srcNode.label);
        dstParent.next = newNode;
        map.put(srcNode, newNode);
        traverseCreate(map, srcNode.next, newNode);
    }

    private void traverseRandomLink(HashMap<RandomListNode, RandomListNode> map, RandomListNode srcNode, RandomListNode dstNode) {
        if (null == srcNode) return;
        if (null != srcNode.random) {
            dstNode.random = map.get(srcNode.random);
        }
        traverseRandomLink(map,srcNode.next, dstNode.next);
    }
}
