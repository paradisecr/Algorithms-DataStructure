package me.rui.sword.comprehensive;

/**
 * Created by cr on 2017/4/24.
 *
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 * 1. 只有一个数字的情形下比较好解决，使用异或；
 * 2. 将现有情况拆分成多个只有一个数字的情形。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array== null || array.length < 2) return;
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        // 1.遍历并异或，得到最后数字
        int num = array[0];
        for (int i = 1; i< array.length; i++) {
            num = num ^ array[i];
        }
        // 2.找到异或数字的倒数第一个1的位置
        int digitPos = findLastBitPos(num);
        if (digitPos == -1) return;
        // 3.按照此位置是否为1将数组拆分为两个
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i< array.length; i++) {
            if (isBitOne(array[i], digitPos)) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }
    private int findLastBitPos(int num) {
        if (num == 0) return -1;
        int index = 0;
        while ((num & 1) != 1) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    private boolean isBitOne(int num, int index) {
        int count = 0;
        while (count < index) {
            num = num >> 1;
            count++;
        }
        return (num & 1) == 1;
    }
}
