package me.rui.vm;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by caorui on 2017/10/15.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int num = Integer.valueOf(input);
        int n = input.length();

    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int num = Integer.valueOf(input);
        int n = input.length();
        int res = 0;
        int max = (int) Math.pow(10, n);
        int tmp = (num + max/2) % max;
        char[] cs = String.valueOf(tmp).toCharArray();
        Set <Integer> set = new HashSet();
        for (char c : cs) {
            int nn = c - '0';
            int t = nn;
            int i = 0;
            while ( set.contains(t) ) {
                i++;
                if ((t-i) >=0 && !set.contains(t-i)) {
                    t = t-i;
                    break;
                } else if ((t+i) <= 9 && !set.contains(t+i)) {
                    t = t+i;
                    break;
                }
            }
            nn = t;
            res *= 10;
            res += nn;
            set.add(nn);
        }
        System.out.println(res);
    }
}
