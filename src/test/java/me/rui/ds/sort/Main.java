package me.rui.ds.sort;

/**
 * Created by cr on 2017/3/31.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] cs = str.trim().toCharArray();
        int n = cs.length;
        int count = 0x0;
        for (int i=0; i< n; i+=16) {
            int low = i;
            int high = i+15;
            System.out.printf("%08x  ",low);
//            System.out.print(intToString(16) + "  ");
            for (int j =low; j<=high; j++) {
                System.out.printf("%02d ",cs[j] - 'a');
                if (j == 7) System.out.print("  ");
                System.out.print(" ");
            }
            System.out.print("  ");
            for (int j =low; j<=high; j++) {
                System.out.print(cs[j]);
            }
            System.out.println();
        }
    }
    public static String intToString(int number) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<8; i++) {
            result.append(number & 1);
            number = number/2;
        }
        return reverse(result.toString());
    }
    public static String reverse(String s){
        char[] ch = s.toCharArray();
        String result = "";
        for(int i = ch.length - 1; i >= 0; i--){
            result+=ch[i];
        }
        return result;
    }
}
