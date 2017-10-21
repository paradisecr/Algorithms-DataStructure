package me.rui.tt.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by caorui on 2017/9/11.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> curList = new ArrayList<>();
        List<Integer> nextList = new ArrayList<>();
        for (int i =0; i<num; i++) {
            curList.add(scanner.nextInt());
        }
        int res = 0;
        boolean flag = true;
        while (flag && curList.size() >1) {
            flag = false;
            nextList.add(curList.get(0));
            for (int i=1; i<curList.size() ; i++) {
                if (curList.get(i) > curList.get(i-1)) {
                    flag = true;
                    continue;
                }
                nextList.add(curList.get(i));
            }
            if (flag) res++;
            List<Integer> tmp = curList;
            curList = nextList;
            nextList = tmp;
            nextList.clear();
        }
        System.out.println(res);
    }
}
