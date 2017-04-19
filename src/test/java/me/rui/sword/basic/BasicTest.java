package me.rui.sword.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cr on 2017/4/19.
 */
public class BasicTest {

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
