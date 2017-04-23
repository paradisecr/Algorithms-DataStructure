package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/20.
 * 斐波那契数列
 *  题目描述：
 *  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 *
 *  题目变种：
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  思路：
 *  为增加效率，从低向上计算，直接利用之前的结果。
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prePre = 0;
        int pre = 1;
        int numN = prePre;
        for (int i = 2; i<= n; i++) {
            numN = pre + prePre;
            prePre = pre;
            pre = numN;
        }
        return numN;
    }
}
