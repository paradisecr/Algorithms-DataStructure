package me.rui;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int l = scanner.nextInt();
        int[] parent = new int[num];
        for (int i=0; i<num-1; i++) {
            parent[i] = scanner.nextInt();
        }
        String a;
        System.out.println(maxNodesVisited(parent, l));
    }

    public static int maxNodesVisited(int[] parent, int l)
    {
        int n = parent.length + 1;
        int d = 0;
        for (int i = 1; i < n; i++) {
            int c = 1;
            int x = i;
            while (parent[x-1] != 0) {
                x = parent[x-1];
                c++;
            }
            d = Integer.max(d, c);
        }
        if (d >= l) {
            return l + 1;
        }
        return Integer.min(n, 1 + d + (l - d) / 2);
    }

    public static int max(int a, int b) {
        return a> b? a:b;
    }

    public static int min(int a, int b) {
        return a< b? a:b;
    }
}
