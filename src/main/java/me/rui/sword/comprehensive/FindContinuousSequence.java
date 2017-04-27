package me.rui.sword.comprehensive;

import java.util.ArrayList;

/**
 * Created by cr on 2017/4/24.
 * 和为S的连续正数序列
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list;
        if (sum <= 1) {
            return result;
        }
        int bound = (sum+1)/2;
        int left = 1;
        int right = 2;
        int count = 0;
        while (right <= bound) {
            count = 0;
            for (int i = left; i<=right; i++) {
                count+=i;
            }
            if (count < sum) {
                right++;
            } else if (count > sum){
                left++;
            } else {
                list = new ArrayList<>();
                for (int j = left; j<=right; j++) {
                    list.add(j);
                }
                result.add(list);
                right++;
            }
        }
        return result;
    }
}
