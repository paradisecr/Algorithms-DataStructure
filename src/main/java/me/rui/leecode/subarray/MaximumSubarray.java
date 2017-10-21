package me.rui.leecode.subarray;

/**
 * Created by caorui on 2017/9/2.
 * Code  53
 * 最大连续子序列的和
 *
 * 思路：
 *
 */
public class MaximumSubarray {
    public int maxSubarray(int[] nums) {
        int maxSofar = nums[0];
        int max = nums[0];
        for (int i  = 1; i<nums.length; i++) {
            maxSofar = Integer.max(nums[i], maxSofar + nums[i]);
            max = Integer.max(maxSofar, max);
        }
        return max;
    }
}
