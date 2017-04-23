package me.rui.sword.greatidea;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 注意：
 * 1. 书中的方法得到的不是字典序；
 * 2. 要考虑重复问题。
 * 3. 还需找到更有效率的方法。
 */
public class Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> strList = new ArrayList<>();
        if (null == str || str.length() <1) return strList;
        char[] chars = str.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (Character ch : chars) {
            linkedList.add(ch);
        }
        StringBuffer buffer = new StringBuffer();
        permutationInternal(linkedList,buffer, strList);
        return strList;
    }

    private void permutationInternal(LinkedList<Character> chars,StringBuffer buffer, ArrayList<String> strList) {
        if (chars.size() == 1) {
            buffer.append(chars.get(0));
            String str = buffer.toString();
            if (!strList.contains(str)) strList.add(str);
            buffer.delete(buffer.length() - 1, buffer.length());
            return;
        }
        for (int i = 0; i< chars.size(); i++) {
            char ch = chars.get(i);
            buffer.append(ch);
            chars.remove(i);
            permutationInternal(chars, buffer,strList);
            chars.add(i, ch);
            buffer.delete(buffer.length() - 1, buffer.length());
        }

    }
}
