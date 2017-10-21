package me.rui.didi;

/**
 * Created by caorui on 2017/9/10.
 */
import java.util.Scanner;

public class Main2 {
    public static int function(int[] data) {
        int length = data.length;
        int result = 0;
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (data[i] == 0) {
                result++;
                lastIndex = i;
                continue;
            }
            for (int j = lastIndex + 1; j < i; j++) {
                int tmp = 0;
                for (int k = j; k <= i; k++) {
                    tmp ^= data[k];
                }
                if (tmp == 0) {
                    result++;
                    lastIndex = i;
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
            }
            System.out.println(function(data));
        }

    }

}