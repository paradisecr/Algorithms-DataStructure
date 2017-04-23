package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/20.
 *  题目描述
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (null == array || array.length == 0) return  0;
        if (array.length == 1) return array[0];
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        while (right != left + 1) {
            if (array[mid] >= array[left] && array[mid] > array[right] ) {
                left = mid;
                mid = (left + right) / 2;
            } else if (array[mid] <= array[right] && mid < array[left]) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                for (int i = left; i < right; i++) {
                    if (array[i+1] < array[i]) {
                        left = i;
                        break;
                    }
                }
                break;
            }
        }
        return array[left+1];
    }
}
