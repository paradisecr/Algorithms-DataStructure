package me.rui.zh;

import java.util.Scanner;

/**
 * Created by caorui on 2017/9/13.
 */
public class Main {

    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static int nlcm(int a, int b) {
        if (a > b) {
            return a*b/gcd(a,b);
        }
        return a*b/gcd(b,a);
    }

    public static void dfs(int cur, int a, int b, int n) {
        if (cur > n) return;
        count++;
        dfs(cur * a, a, b, n);
        dfs(cur *b, a, b, n);
    }
}
