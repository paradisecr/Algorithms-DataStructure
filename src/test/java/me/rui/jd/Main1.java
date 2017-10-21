package me.rui.jd;

import java.util.*;

/**
 * Created by caorui on 2017/9/8.
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        Map<Long, String> map1 = new HashMap<Long, String>();
        Long temp;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp = (long) Math.pow(i, j);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    map1.put(temp, map1.get(temp) + "," + i + "-" + j);
                } else {
                    map.put(temp, 1);
                    map1.put(temp, i + "-" + j);
                }
            }
        }
        Integer count = 0;
        Integer flag = 1000000007;
        Iterator<Long> keyIterator = map.keySet().iterator();
        while(keyIterator.hasNext()){
            long l = map.get(keyIterator.next());
            count = (int)(count + l*l)%flag;
        }
        System.out.println(count);
    }
}
