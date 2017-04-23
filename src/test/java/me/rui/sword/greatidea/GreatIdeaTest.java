package me.rui.sword.greatidea;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cr on 2017/4/22.
 */
public class GreatIdeaTest {

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
