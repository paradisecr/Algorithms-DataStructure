package me.rui.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/10/9.
 */
public class JumpGame {

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump2(nums1) == true);
        System.out.println(solution.canJump2(nums2) == false);
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length; // 要注意边界
        int i=0;
        for (int reach = 0; i< n && i<= reach; ++i) {
            reach = Integer.max(reach,nums[i] + i);
        }
        return i == n;
    }

    // 会因此超时
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> can = new HashMap<>();
        return canJump(nums, can, 0);
    }

    private boolean canJump(int[] nums, Map<Integer, Boolean> can, int index) {
        if (index == nums.length - 1) return true;
        if (can.containsKey(index)) return can.get(index);
        int n = nums[index];
        if (n == 0) {
            can.put(index, false);
            return false;
        }
        for (int i =1; i<= n; i++) {
            if ((index + i) > (nums.length - 1)) break;
            if (canJump(nums, can, index + i)) {
                can.put(index, true);
                return true;
            }
        }
        can.put(index, false);
        return false;
    }
}
