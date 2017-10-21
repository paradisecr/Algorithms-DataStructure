package me.rui.tencent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/9/13.
 */
public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

    }

    public static int solution(int n) {
        // 1. 求m
        int tmp = 1;
        int maxI= 0;
        map.put(0,1);
        while (tmp < n) {
            tmp *= 2;
            maxI++;
            map.put(maxI, tmp);
        }
        int m = 2*maxI;
        maxI = maxI - 1;

        return 0;
    }

    public static int get(int i) {
        return map.get(i/2);
    }
}
