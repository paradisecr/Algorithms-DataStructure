package me.rui.sword.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cr on 2017/4/19.
 */
public class BasicTest {


    @Test
    public void reConstructBinaryTreeTest() {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        ReConstructBinaryTree.TreeNode tree = reConstructBinaryTree.reConstructBinaryTree(pre, in);
        int[] preArray = reConstructBinaryTree.preTraverse(tree);
        int[] inArray = reConstructBinaryTree.inTraverse(tree);
        Assert.assertArrayEquals(pre, preArray);
        Assert.assertArrayEquals(in, inArray);
    }

    @Test
    public void printListFromTailToHeadTest() {
        PrintListFromTailToHead.ListNode root = null;
        PrintListFromTailToHead.ListNode cur = null;
        ArrayList<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                root = new PrintListFromTailToHead.ListNode(5 - i);
                cur = root;
                expectedList.add(cur.val);
            } else {
                cur.next = new PrintListFromTailToHead.ListNode(5 - i);
                cur = cur.next;
                expectedList.add(cur.val);
            }
        }
        Collections.reverse(expectedList);
        Assert.assertEquals("Should equal.", expectedList, new PrintListFromTailToHead().printListFromTailToHead(root));
    }

    @Test
    public void replaceSpaceTest() {
        String srcStr = "We are happy.";
        String expectedStr = "We%20are%20happy.";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        Assert.assertEquals("Should equal", expectedStr, replaceSpace.replaceSpace(srcStr));
    }
    /**
     * 二维数组中的查找测试
     */
    @Test
    public void findInPartiallySortedMatrixTest() {
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        FindInPartiallySortedMatrix finder =  new FindInPartiallySortedMatrix();
        for (int[] row : array) {
            for (int num : row) {
                Assert.assertTrue(finder.find(num, array));
            }
        }
        Assert.assertFalse(finder.find(-1, array));

    }
}
