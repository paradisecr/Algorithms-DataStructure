package me.rui.sword.optimize;

/**
 * Created by cr on 2017/4/23.
 *  题目描述
 *  在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 *
 *  思路：
 *  第一次扫描使用hash表记录计数；
 *  第二次扫描找到第一个计数为1的字符的位置。
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (null == str || str.length() == 0) return -1;
        int[] count = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i< chars.length; i++) {
            count[chars[i]]++;
        }
        for (int i = 0; i< chars.length; i++) {
            if (count[chars[i]] == 1) return i;
        }
        return -1;
    }
}
