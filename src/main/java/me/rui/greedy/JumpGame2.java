package me.rui.greedy;

/**
 * Created by caorui on 2017/10/10.
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1,1,4};
        System.out.println(jump(nums1));
    }
    public static int jump(int[] nums) {
        int nextMaxIndex = 0;
        int curMaxIndex = 0;
        int i =0;
        int step = 0;
        while (nextMaxIndex < nums.length - 1){
            curMaxIndex = nextMaxIndex;
            step++;
            for (; i<= curMaxIndex; ++i) {
                nextMaxIndex = Integer.max(nextMaxIndex, nums[i] + i);
            }
        }
        return step;
    }
}
