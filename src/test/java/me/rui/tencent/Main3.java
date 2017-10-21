package me.rui.tencent;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int count =0;
        while (a != A ) {
            while(b != B){
                if ((A%2) == 0 && (B%2) == 0) {
                    A /= 2;
                    B /= 2;
                    count++;
                } else {
                    A--;
                    B--;
                    count++;
                }
            }
        }
        count = (a==A && b==B) ? count : 0;
        System.out.println(count);
    }

    private static int getCount(int a, int b, int A, int B) {
        int count = 0;
        while (a != A ) {
            while(b != B){

                if ((A%2) == 0 && (B%2) == 0) {
                    A /= 2;
                    B /= 2;
                    count++;
                    continue;
                } else {
                    A--;
                    B--;
                    count++;
                    continue;
                }
            }
            if(b == B){
                break;
            }
        }
        return a==A && b==B ? count : 0;
    }
}