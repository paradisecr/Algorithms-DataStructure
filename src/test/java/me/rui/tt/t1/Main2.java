package me.rui.tt.t1;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] like = new int[n];
        Map<Integer, List<Integer>> likeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            like[i] = scanner.nextInt();
            if (!likeMap.containsKey(like[i])) {
                List<Integer> list = new ArrayList<Integer>();
                likeMap.put(like[i], list);
            }
            likeMap.get(like[i]).add(i + 1);
        }
        int qNum = scanner.nextInt();
        for (int i = 0; i < qNum; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> list = likeMap.get(k);
            if (list == null) {
                System.out.println(0);
                continue;
            }
            int right = Collections.binarySearch(list, r);
            if (right >= 0) {
                right++;
            } else {
                right = -1 - right;
            }
            int left = Collections.binarySearch(list, l);
            if (left >= 0) {
            } else {
                left = -1 - left;
            }
            System.out.println(right - left);
        }
    }
}