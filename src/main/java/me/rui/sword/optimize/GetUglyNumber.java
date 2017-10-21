package me.rui.sword.optimize;

import java.util.Scanner;

/**
 * Created by cr on 2017/4/23.
 *  题目描述
 *  把只包含素因子2、3和5的数称作丑数（Ugly Number）。
 *  例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 *
 *  思路：
 *  从小到大，顺序构造丑数。缺点是占用空间比较大。
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println(getUglyNumber(index));
    }
    public static  int getUglyNumber(int index) {
        if (index <=0) return 0;
        int[] seq = new int[index];
        seq[0] = 1;
        int p2=-1,p3=-1,p5=-1,right=0;
        int n2=0, n3=0, n5=0;
        while (right < index-1) {
            while (n2 <= seq[right]) {
                n2 = seq[++p2] * 2;
            }
            while (n3 <= seq[right]) {
                n3 = seq[++p3] * 3;
            }
            while (n5 <= seq[right]) {
                n5 = seq[++p5] * 5;
            }
            int min = min(n2, n3,n5);
            seq[++right] = min;
        }
        return seq[right];
    }
    private static int min(int a, int b, int c) {
        int tmp = a;
        if (b < tmp) tmp = b;
        if (c < tmp) tmp = c;
        return tmp;
    }
}
