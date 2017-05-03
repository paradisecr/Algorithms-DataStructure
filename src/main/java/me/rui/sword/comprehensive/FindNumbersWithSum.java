package me.rui.sword.comprehensive;

import java.util.ArrayList;

/**
 * Created by cr on 2017/4/27.
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 1) return list;
        int left = 1;
        int right = array.length-1;
        int count = 0;
        while (left < right) {
            count = array[left] + array[right];
            if (count < sum) {
                right++;
            } else if (count > sum){
                left++;
            } else {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
        }
        return list;
    }
}
