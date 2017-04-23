package me.rui.sword.greatidea;

import me.rui.sword.util.ListNode;
import me.rui.sword.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr on 2017/4/22.
 */
public class GreatIdeaTest {

    @Test
    public void getLeastNumbersSolution() {
        GetLeastNumbersSolution solution = new GetLeastNumbersSolution();
        int[] array = new int[]{4,5,1,6,2,7,3,8};
        Integer[] expected = new Integer[]{1,2,3,4};
        Integer[] expected2 = new Integer[]{1,2,3,4,5,6,7,8};
        List<Integer> resultList = solution.getLeastNumbers_Solution2(array,4);
        Integer[] result = new Integer[resultList.size()];
        Assert.assertArrayEquals(expected, resultList.toArray(result));

    }

    @Test
    public void permutationTest() {
        Permutation permutation = new Permutation();
        String str = "abc";
        System.out.println(permutation.permutation(str));
    }

    @Test
    public void findPathTest() {
        FindPath findPath = new FindPath();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node2.left = node3;
        ArrayList<ArrayList<Integer>> results = findPath.findPath(node1, 6);
    }
    @Test
    public void verifySquenceOfBST() {
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        int[] rightSeq = new int[] {5,7, 6, 9, 11, 10, 8};
        int[] wrongSeq = new int[] {7, 4, 6, 5};
        Assert.assertTrue(verifySquenceOfBST.verifySquenceOfBST(rightSeq));
        Assert.assertFalse(verifySquenceOfBST.verifySquenceOfBST(wrongSeq));
    }
    @Test
    public void IsPopOrder() {
        int[] pushA = new int[] {1,2,3,4,5};
        int[] rightPop = new int[]{4,5,3,2,1};
        int[] wrongPop = new int[]{4,3,5,1,2};
        IsPopOrder isPopOrder = new IsPopOrder();
        Assert.assertTrue(isPopOrder.isPopOrder(pushA, rightPop));
        Assert.assertFalse(isPopOrder.isPopOrder(pushA, wrongPop));
    }
    @Test
    public void printMatrixTest() {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] matrix1 = new int[][]{
                {1,2,3},
                {8,9,4},
                {7,6,5}
        };
        int[][] matrix2 = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        int[][] matrix3 = new int[][]{{1,2,3,4,5}
        };

        System.out.println(printMatrix.printMatrix(matrix2));
    }
}
