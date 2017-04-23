package me.rui.sword.optimize;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cr on 2017/4/23.
 */
public class OptimizeTest {

    @Test
    public void inversePairs() {
        InversePairs solution  = new InversePairs();
        int[] seq = new int[]{1,2,3,4,5,6,7,0};
        int count = solution.inversePairs(seq);
        int expected = 7;
        Assert.assertEquals(expected, count);
    }
    @Test
    public void getUglyNumberTest() {
        GetUglyNumber solution = new GetUglyNumber();
        int uglyNum = solution.getUglyNumber(3);
        int expectedNum = 3;
        Assert.assertEquals(expectedNum, uglyNum);
    }

    @Test
    public void printMinNumber() {
        int[] seq = new int[]{3,5,1,4,2};
        PrintMinNumber solution = new PrintMinNumber();
        String result = solution.printMinNumber(seq);
    }

}
