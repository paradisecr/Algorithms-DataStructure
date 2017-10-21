package me.rui.tt.t1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        Map<Integer, List<Integer>> color2Pos = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i<n; i++) {
            int num = scanner.nextInt();
            if (num == 0) continue;
            for (int j = 0; j<num; j++) {
                int color = scanner.nextInt();
                if (!color2Pos.containsKey(color)) {
                    color2Pos.put(color, new ArrayList<Integer>());
                }
                color2Pos.get(color).add(i);
            }
        }
        int result = 0;
        for (List<Integer> list : color2Pos.values()) {
            boolean flag = false;
            for (int i =0; i<list.size() -1; i++) {
                if ((list.get(i+1) - list.get(i) <= (m-1))) {
                    result++;
                    flag = true;
                    break;
                }
                if (flag) continue;
            }
            if ((list.get(0) + n - list.get(list.size()-1)) <= (m-1)) result++;
        }
        System.out.println(result);
    }
}