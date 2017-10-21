package me.rui.hw;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by caorui on 2017/9/26.
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] list = input.split("\\|");
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split("\\.");
                String[] s2 = o2.split("\\.");
                int size = s1.length < s2.length ? s1.length : s2.length;
                for (int i = 1; i <= size; i++) {
                    if (s1[s1.length - i].compareTo(s2[s2.length -i]) != 0)
                        return  s1[s1.length - i].compareTo(s2[s2.length -i]);
                }
                return s1.length - s2.length;
            }
        });
        for (int i=0; i< list.length; i++) {
            if (i!=0) {
                System.out.print("|");
            }
            System.out.print(list[i]);
        }
    }

    @Test
    public void test1() {
        System.out.println("com".compareTo("org"));
    }
}
