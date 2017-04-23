package me.rui.sword.greatidea;

/**
 * Created by cr on 2017/4/23.
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (null == array || array.length == 0) return 0;
        int lastNum = array[0];
        int count = 1;
        for (int i = 1; i< array.length; i++) {
            if (array[i] != array[i-1]) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                lastNum = array[i];
                count = 1;
            }
        }
        if (!check(array, lastNum)) return 0;  // 需要对结果进行校验
        return lastNum;
    }

    private boolean check(int[] array, int num) {
        int count = 0;
        for (int i = 0; i< array.length; i++) {
            if (array[i] == num) count++;
            if (count > array.length/2) return true;
        }
        return false;
    }
}
