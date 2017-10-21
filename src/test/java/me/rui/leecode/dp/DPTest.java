package me.rui.leecode.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by caorui on 2017/6/19.
 */
public class DPTest {

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    @Test
    public void testNumArray() {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        Assert.assertEquals(1, numArray.sumRange(0,2));
        Assert.assertEquals(-1, numArray.sumRange(2,5));
        Assert.assertEquals(-3, numArray.sumRange(0,5));
    }
}
