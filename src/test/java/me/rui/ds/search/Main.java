package me.rui.ds.search;

/**
 * Created by caorui on 2017/8/12.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in );
        int x = scan.nextInt();
        int f = scan.nextInt();
        int d = scan.nextInt();
        int p = scan.nextInt();
        int day = d / x;
        if (day <= f) {
            System.out.println(day);
        }else{
            day = f;
            int result = d - f * x;
            System.out.println(day + result / (x + p));
        }
    }
}