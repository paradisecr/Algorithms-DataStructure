package me.rui.hw;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by caorui on 2017/9/26.
 */
public class Code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d[-](\\d){3}[-](\\d){5}";

        String prefix = scanner.next();
        if(!Pattern.matches(pattern, prefix)) {
            System.out.println("ERROR");
            return;
        }
        String tmp = prefix.replace("-","");
        char[] chs = tmp.toCharArray();
        int num = 0;
        String tail;
        for (int i=0; i<chs.length; i++) {
            num += (chs[i] - '0') * (i+1);
        }
        num = num % 11;
        if (num != 10) {
            tail = "-" + num;
        } else {
            tail = "-X";
        }
        System.out.println(prefix + tail);
    }
}
