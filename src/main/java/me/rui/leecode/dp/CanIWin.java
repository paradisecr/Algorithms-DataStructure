package me.rui.leecode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/10/8.
 */
public class CanIWin {


    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(5,50));
    }


    boolean[] visited;

    Map<Integer, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;  // important ????
        if(sum < desiredTotal) return false;
        if (desiredTotal <=0) return true;
        map = new HashMap<>();
        visited = new boolean[maxChoosableInteger];
        return canIWinInternal(maxChoosableInteger, desiredTotal);
    }

    private boolean canIWinInternal(int maxChoosableInteger, int desiredTotal ) {
        if (desiredTotal <= 0) return false;
        int key = booleanToInt(visited);
        if (map.containsKey(key)) return map.get(key);
        for (int i = 0; i< maxChoosableInteger; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (!canIWinInternal(maxChoosableInteger, desiredTotal - (i+1))) {
//                map.put(key, true);
                visited[i] = false; // very important
                return true;
            }
            visited[i] = false;
        }
        map.put(key, false);
        return false;
    }

    private int booleanToInt(boolean[] bits) {
        int res = 0;
        for (int i = bits.length - 1; i>=0; i--) {
            res = res << 1;
            if (bits[i]) res |= 1;
        }
        return res;
    }
}
