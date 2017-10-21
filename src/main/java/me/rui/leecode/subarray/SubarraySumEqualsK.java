package me.rui.leecode.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/9/2.
 */
public class SubarraySumEqualsK {
    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int result = 0;
        int sum = 0;
        preSumMap.put(0,1); // ???
        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            if (preSumMap.containsKey(sum - k)) {
                result += preSumMap.get(sum - k);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) +1);
        }
        return result;
    }
}
