package me.rui.leecode.dfs;

/**
 * Created by caorui on 2017/10/8.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[][] res = new int[nums.length+1][2];
        for (int i=1; i<= nums.length; i++) {
            // 0 for not rob, 1 for rob
            res[i][0] = Integer.max(res[i-1][0], res[i-1][1]);
            res[i][1] = nums[i-1] + res[i-1][0];
        }
        return Integer.max(res[nums.length][0], res[nums.length][1]);
    }

    public int rob2(int[] nums) {
        int preNotRob=0, preRob=0;
        for (int num : nums) {
            int tmpNotRob = Integer.max(preNotRob, preRob);
            preRob = num + preNotRob;
            preNotRob = tmpNotRob;
        }
        return Integer.max(preNotRob, preRob);
    }

}
