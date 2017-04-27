package me.rui.sword.comprehensive;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cr on 2017/4/23.
 */
public class ComprehensiveTest {
    @Test
    public void getNumberOfKTest() {
        GetNumberOfK solution = new GetNumberOfK();
        int[] seq = new int[]{3,3,3,3,4,5};
        int k = 3;
        int expected = 4;
        Assert.assertEquals(expected, solution.getNumberOfK(seq, k));
    }
}
