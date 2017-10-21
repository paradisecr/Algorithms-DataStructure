package me.rui.leecode.dfs;

/**
 * Created by caorui on 2017/10/8.
 */
public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Integer.max(robInternal(nums, 0, nums.length - 2),
                robInternal(nums, 1, nums.length - 1));
    }
    public int robInternal(int[] nums, int start, int end) {
        int preNotRob=0, preRob=0;
        for (int i = start; i<= end; i++) {
            int num = nums[i];
            int tmpNotRob = Integer.max(preNotRob, preRob);
            preRob = num + preNotRob;
            preNotRob = tmpNotRob;
        }
        return Integer.max(preNotRob, preRob);
    }

}
