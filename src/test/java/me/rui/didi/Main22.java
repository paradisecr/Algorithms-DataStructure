package me.rui.didi;

/**
 * Created by caorui on 2017/9/10.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            List<List<Integer>> colorList = new ArrayList<List<Integer>>();
            for (int i = 0; i < c; i++) {
                List<Integer> list=new ArrayList<>();
                colorList.add(list);
            }
            for (int i = 0; i < n; i++) {
                int colorNum = scanner.nextInt();
                for (int j = 0; j < colorNum; j++) {
                    int color = scanner.nextInt();
                    colorList.get(color - 1).add(i);
                }
            }
            int res = 0;
            for (List<Integer> list : colorList) {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        if ((n + list.get(0) - list.get(i))  <= (m-1)) {
                            flag = true;
                        }
                    } else {
                        if ((list.get(i + 1) - list.get(i)) <= (m-1)) {
                            flag = true;
                        }
                    }
                    if (flag) break;
                }
                if (flag) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}