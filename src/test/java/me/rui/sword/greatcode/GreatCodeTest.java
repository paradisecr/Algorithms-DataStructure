package me.rui.sword.greatcode;

import me.rui.sword.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cr on 2017/4/20.
 */
public class GreatCodeTest {

    @Test
    public void mergeListTest() {

    }

    @Test
    public void reverseListTest() {
        ReverseList reverseList = new ReverseList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode reversedRoot = reverseList.reverseList(node1);
        Assert.assertEquals(reversedRoot.val, 3);
        Assert.assertEquals(reversedRoot.next.val, 2);
        Assert.assertEquals(reversedRoot.next.next.val, 1);
    }

    @Test
    public void fndKthToTail() {
        FindKthToTail findKthToTail = new FindKthToTail();
        FindKthToTail.ListNode root = new FindKthToTail.ListNode(1);
        FindKthToTail.ListNode node = new FindKthToTail.ListNode(2);
        root.next = node;
        node.next = new FindKthToTail.ListNode(3);
        Assert.assertEquals(root, findKthToTail.FindKthToTail(root, 3));
    }
    @Test
    public void reOrderArrayTest() {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] seq1 = new int[] {2,1,2,1,1,2};
        int[] seq2 = new int[] {2,1,2,1,1,2};
        int[] seq3 = new int[] {2,1,2,1,1,2};
        int[] expected = new int[] {1,1,1,2,2,2};
        reOrderArray.reOrderArray(seq1);
        Assert.assertArrayEquals(expected, seq1);
        reOrderArray.mergeReOrderArray(seq2);
        Assert.assertArrayEquals(expected, seq2);
        reOrderArray.bestReOrderArray(seq3);
        Assert.assertArrayEquals(expected, seq3);
    }
}
