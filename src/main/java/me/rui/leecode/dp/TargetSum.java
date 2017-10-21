package me.rui.leecode.dp;

import me.rui.etc.alibaba.Main;

/**
 * 494. Target Sum
 * Created by caorui on 2017/10/4.
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int S = 3;
        TargetSum solution = new TargetSum();
        System.out.println(solution.findTargetSumWays(nums, S));
    }
    public int findTargetSumWays(int[] nums, int S) {
        // DP
        return findTargetSumWaysInternal(nums, S, nums.length - 1);
    }

    private int findTargetSumWaysInternal(int[] nums, int S, int end) {
        if (end == -1) {
            if (S == 0) return 1;
            return 0;
        }
        int leftNum = findTargetSumWaysInternal(nums, S - nums[end], end -1);
        int rightNum = findTargetSumWaysInternal(nums, S + nums[end], end -1);
        return leftNum + rightNum;
    }
}
