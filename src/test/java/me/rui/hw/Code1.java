package me.rui.hw;

import java.util.*;

/**
 * Created by caorui on 2017/9/26.
 */
public class Code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next().trim();
        String str2 = scanner.next().trim();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        if (str1.isEmpty() || str2.isEmpty()) return;
        for (char c : chars1) {
            set1.add(c);
        }
        for (char c : chars2) {
            set2.add(c);
        }
        for (char c : set1) {
            if (set2.contains(c)){
                str1 = str1.replace(c, '_');
                str2 = str2.replace(c, '_');
            }
        }
        System.out.println(str1);
        System.out.println(str2);
    }
}
