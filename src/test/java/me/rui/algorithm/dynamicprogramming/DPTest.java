package me.rui.algorithm.dynamicprogramming;

import org.junit.Test;

/**
 * Created by cr on 2017/4/27.
 */
public class DPTest {

    @Test
    public void lcsTest() {
        LCSUp solution = new LCSUp();
        String a = "bedaacbade";
        String b = "dccaeedbeb";
        int expectedLenth = 5;
        String rs = solution.lcs(a,b);
        System.out.println(rs);
    }
}
