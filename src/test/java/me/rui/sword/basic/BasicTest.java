package me.rui.sword.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cr on 2017/4/19.
 */
public class BasicTest {



    @Test
    public void power() {
        Power power = new Power();
        Assert.assertEquals(16.0, power.power(2.0, 4), 0.0000001);
    }

    @Test
    public void nmberOf1Test() {
        Assert.assertEquals(3, new NumberOf1().numberOf1(7));
    }
    @Test
    public void fibonacciTest() {
        Fibonacci fibonacci  = new Fibonacci();
        Assert.assertEquals(3, fibonacci.fibonacci(4));
    }
    @Test
    public void minNumberInRotateArray() {
        MinNumberInRotateArray finder = new MinNumberInRotateArray();
        int[] array1 = new int[]{3,4,5,1,2};
        Assert.assertEquals(1,finder.minNumberInRotateArray(array1));
        int[] array2 = new int[]{1,1,0,1,1};
        Assert.assertEquals(0,finder.minNumberInRotateArray(array2));
    }

    @Test
    public void stackToQueueTest() {
        try {
            StackToQueue queue = new StackToQueue();
            queue.push(1);
            Assert.assertEquals(1,queue.pop());
            queue.push(1);
            queue.push(2);
            Assert.assertEquals(1,queue.pop());
            queue.push(3);
            Assert.assertEquals(2,queue.pop());
            Assert.assertEquals(3,queue.pop());
        } catch (Exception e) {

        }

    }

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
