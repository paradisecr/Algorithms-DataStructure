package me.rui.sword.optimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字
 *
 * 思路：
 * 自定义排序规则。
 */
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        if (null == numbers || numbers.length == 0) return "";
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                String s12 = s1 + s2;
                String s21 = s2 + s1;
                for (int i =0; i< s12.length(); i++) {
                    char c1 = s12.charAt(i);
                    char c2 = s21.charAt(i);
                    if (c1 == c2) continue;
                    return c1 - c2;
                }
                return 0;
            }
        });
        StringBuffer buffer = new StringBuffer();
        for (Integer num : list) {
            buffer.append(num);
        }
        return buffer.toString();
    }
}
