package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/20.
 *  题目描述:
 *  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 *  要点：
 *  底数为零的判断，double相近的两个数判断，偶数次方的优化。
 */
public class Power {
    public double power(double base, int exponent) {
        // 1. invalid判断
        if (isApproximateZero(base) && exponent < 0) return 0.0;
        boolean isExponentNegative = exponent < 0 ? true : false;
        if (isExponentNegative) exponent = -exponent;
        // 2. power
        double result = powerInternal(base, exponent);
        if (isExponentNegative) result = 1/result;
        return result;
    }

    private double powerInternal(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent == 1) return base;
        double result = powerInternal(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    private boolean isApproximateZero(double num) {
        if (num > -0.0000001 && num < 0.0000001) {
            return true;
        }
        return false;
    }
}
