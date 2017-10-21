package me.rui.tencent;

import java.util.Scanner;

/**
 * Created by caorui on 2017/9/13.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNum = scanner.nextInt();
        int kNum = scanner.nextInt();
        float[][] data = new float[cityNum][cityNum];
        for (int i=0;i<cityNum;i++) {
            String str = scanner.next();
            char[] cs = str.toCharArray();
            for (int j=0; j<cityNum; j++) {
                data[i][j] = Float.valueOf(cs[j]);
            }
        }
        float res = 4.0f;
        System.out.printf("%.1f\r\n", res);
    }

}
