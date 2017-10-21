package me.rui.leecode.subarray;

/**
 * Created by caorui on 2017/9/2.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {-4, -3, -2};
        System.out.println(new MaxProductSubArray().maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int maxSofar = nums[0];
        int minSofar = nums[0];
        int maxTmp;
        int minTmp;
        int max =maxSofar;
        int min = minSofar;
        for(int i= 1; i<nums.length;i++){
            maxTmp = Integer.max(nums[i], Integer.max(nums[i]*maxSofar, nums[i]*minSofar));
            minTmp = Integer.min(nums[i], Integer.min(nums[i]*maxSofar, nums[i]*minSofar));
            maxSofar = maxTmp;
            minSofar = minTmp;
            max = Integer.max(max, Integer.max(maxSofar, minSofar));
            min = Integer.min(min, Integer.min(minSofar, maxSofar));
        }
        return max;
    }
}
