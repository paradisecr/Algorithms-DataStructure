package me.rui.zh;

import java.util.Scanner;

/**
 * Created by caorui on 2017/9/13.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int start = a;
        if (start < b) start  = b;
        int count = 0;
        for (int i = start; i<=n; i++) {
            if (i%a == 0 && i%b == 0 ) count++;
        }
        System.out.println(count);
    }
}
