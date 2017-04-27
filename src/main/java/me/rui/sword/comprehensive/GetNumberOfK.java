package me.rui.sword.comprehensive;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        if (null == array || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right)/2;
            if (array[mid] <k) {
                left = mid + 1;
            } else if (array[mid] >k) {
                right = mid -1;
            } else {
                break;
            }
        }
        if (array[mid] != k) return 0;
        int count = 1;
        left = mid-1;
        right = mid + 1;
        while (left >=0 && array[left--] == k) count++;
        while (right <= array.length-1 && array[right++] == k) count++;
        return count;
    }
}
