package me.rui.didi;

import sun.invoke.util.VerifyAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by caorui on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 1. 求所有xor为0的区间
        List<int[]> list = new ArrayList<>();
        for (int i=n-1; i>=0; i--) {
            int val = nums[i];
            if (val == 0) {
                list.add(new int[] {i,i});
                continue;
            }
            for (int j = i-1; j>=0; j--) {
                if ((nums[j] ^ val) ==0) {
                    list.add(new int[] {j,i});
                    break;
                }
            }
        }

        // 2. 贪心选择
        int lastIndex = -1;
        int result = 0;
        for (int i = list.size() -1; i >=0; i--) {
            if (list.get(i)[0] > lastIndex) {
                result++;
                lastIndex = list.get(i)[1];
                continue;
            }
        }
        System.out.println(result);
    }
}
