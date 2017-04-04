package me.rui.ds.sort;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by cr on 2017/3/31.
 * 排序通用操作类
 */
public class SortUtils {

    private static  Scanner scanner = new Scanner(System.in);

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("[^\\n]*\\n");

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }


    public static Integer[] randowSeq(int num, int scope) {
        Integer[] seq = new Integer[num];
        for (int i=0; i<seq.length; i++) {
            seq[i] = random.nextInt(scope);
        }
        return seq;
    }

    public static boolean less(Comparable v, Comparable u) {
        return v.compareTo(u) < 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable a[]) {
        for (Comparable e : a) {
            System.out.println(e + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i=1; i< a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }


    public static String[] readStrings() {
        String str = scanner.nextLine();
        return WHITESPACE_PATTERN.split(str);
    }


}
