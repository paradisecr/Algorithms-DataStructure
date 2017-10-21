package me.rui.leecode.brainteaser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/10/8.
 */
public class NimGame {

    public static void main(String[] args) {
        NimGame solution = new NimGame();
//        for (int i=1; i<=8; i++) {
//            if (solution.canWinNimMath(i) != solution.canWinNimDownToTop(i)) {
//                System.out.println(i);
//            }
//        }
        System.out.println(solution.canWinNim(1000));
    }
    private Map<Integer, Boolean> map = new HashMap<>();
    public boolean canWinNim(int n) {
        if (n<=0) return false;
        if (map.containsKey(n)) return map.get(n);
        for (int i=1; i<=3; i++) {
            if (!canWinNim(n-i)) {
                return true;
            }
        }
        map.put(n, false);
        return false;
    }
    public boolean canWinNimMath(int n) {
        // Death number 4的倍数
        return !(n%4 == 0);
    }

    public boolean canWinNimDownToTop(int n) {
        boolean[] pre = new boolean[3];
        boolean cur = false;
        for (int i=1; i<=n ;i++) {
            cur = false;
            for (boolean isWin : pre) {
                if (!isWin) cur = true;
            }
            pre[2] = pre[1];
            pre[1] = pre[0];
            pre[0] = cur;
        }
        return cur;
    }
}
