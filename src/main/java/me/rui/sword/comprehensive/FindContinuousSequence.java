package me.rui.sword.comprehensive;

import java.util.ArrayList;

/**
 * Created by cr on 2017/4/24.
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 2) return result;
        int nums = 2;
        int curNums = 2;
        while (true) {
            //1. 奇数
            if (curNums % 2 == 1) {
                // 1.若能整除，可能有可行解;
                if (sum % curNums != 0) continue; // TODO 判断范围
//                int left =
            }
            //2. 偶数
            if (curNums %2 == 0){

            }
        }
    }
}
