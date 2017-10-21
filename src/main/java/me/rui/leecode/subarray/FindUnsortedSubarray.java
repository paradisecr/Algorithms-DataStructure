package me.rui.leecode.subarray;

/**
 * Created by caorui on 2017/9/2.
 */
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        maxs[0] = nums[0];
        mins[nums.length - 1] = nums[nums.length - 1];
        int minIndex = 0;
        int maxIndex = nums.length;
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Integer.max(nums[i], maxs[i-1]);
        }
        for (int i = nums.length - 2; i>=0; i--) {
            mins[i] = Integer.min(nums[i], mins[i+1]);
        }
        for (int i = 0; i< nums.length; i++) {
            if (nums[i]  > mins[i]) {
                minIndex = i;
                break;
            }
            minIndex = i;
        }
        if (minIndex == nums.length - 1) return 0;
        for (int i = nums.length - 1; i>0; i--) {
            if (nums[i] < maxs[i]) {
                maxIndex = i;
                break;
            }
            maxIndex = i;
        }

        return maxIndex - minIndex + 1;
    }
}
