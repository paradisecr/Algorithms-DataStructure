package me.rui.zh;

import java.util.Scanner;

/**
 * Created by caorui on 2017/9/13.
 */
public class Main3 {
    private static int a = 0;
    private static int b = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i=0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        System.out.println(dfs(data, 0));
    }

    public static boolean dfs(int[] data, int index) {
        if (index >= data.length) return a>b;

        // a 1
        a += data[index++];
        // a 1 b 1
        if (index < data.length) {
            b+= data[index++];
            if (!dfs(data, index)) return false;
            b = b - data[--index];
        } else {
            return a > b;
        }

        // a 1 b 2
        if (data.length - 1 - index >=1) {
            b += data[index++];
            b += data[index++];
            if (!dfs(data, index)) return false;
            b = b - data[--index];
            b = b - data[--index];
        }
        // a 2
        a += data[index++];
        // b1
        if (index < data.length) {
            b+= data[index++];
            if (!dfs(data, index)) return false;
            b = b - data[--index];
        } else {
            return a > b;
        }
        // b2
        if (data.length - 1 - index >=1) {
            b += data[index++];
            b += data[index++];
            if (!dfs(data, index)) return false;
            b = b - data[--index];
            b = b - data[--index];
        }

        return false;
    }
}
