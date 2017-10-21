package me.rui.hw;

import java.util.*;

/**
 * Created by caorui on 2017/9/27.
 */
public class Code4 {
    public static void main(String[] args) {
        char[][] data = new char[][]{{},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chs = input.toCharArray();
        Queue<String> curQueue = new LinkedList<>();
        Queue<String> nextQueue = new LinkedList<>();
        curQueue.offer("");
        for (int i=0; i< chs.length; i++) {
            while (!curQueue.isEmpty()) {
                String tmp = curQueue.poll();
                int index = chs[i] - '0' - 1;
                char[] cs = data[index];
                for (char c : cs) {
                    nextQueue.offer(tmp + c);
                }
            }
            Queue q = curQueue;
            curQueue = nextQueue;
            nextQueue = q;
        }
        for (String s : curQueue) {
            System.out.println(s);
        }
    }
}
