package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/20.
 * 题目描述:
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 要点：
 * 一个整数减去1后再和原来的数做位与运算，相当于把源整数最右边的1置为0.
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n =  (n - 1) & n;
        }
        return count;
    }
}
