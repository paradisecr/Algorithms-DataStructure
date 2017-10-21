package me.rui.tt.t1;

/**
 * Created by caorui on 2017/9/10.
 */
import java.util.Random;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        Random random = new Random(System.currentTimeMillis());
        System.out.println(random.nextInt(str.length())/2);
    }
}
