package me.rui.etc.alibaba;

import java.util.*;

/**
 * Created by cr on 2017/4/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] result = handle(scanner.next().trim());
        if (result != null) {
            for (int i = 0; i< result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1) System.out.println();
            }
        }
    }

    public static String[] handle(String str) {
        if (null == str || str.length() == 0) return null;
        if (str.length() == 1) return new String[]{str};
        int max = 0;
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int p1 = 0;
        int p2 = p1;
        int count = 0;
        int weight = 0;
        for (p1 = 0; p1 < str.length(); p1++) {
            for (p2 = p1 + 1; p2 <= str.length(); p2++) {
                String tmpStr = str.substring(p1,p2);
                if (tmpStr.length() <=1) continue;
                if (tmpStr.equals("abcab")) {
                    count = count;
                }
                if (!list2.contains(tmpStr)) list2.add(tmpStr);
                if (map.containsKey(tmpStr)) {
                    count = map.get(tmpStr) + 1;
                }
                else {
                    count = 1;
                    map.put(tmpStr, count);
                    continue;
                }

                map.put(tmpStr, count);
                weight = count * tmpStr.length();
                if (weight > max &&  count > 1) {
                    list.clear();
                    list.add(tmpStr);
                    max = weight;
                    System.out.println(max);
                } else if (weight == max &&  count > 1) {
                    list.add(tmpStr);
                }
            }
        }
        System.out.println(map);
        System.out.println(max);
        return list.toArray(new String[list.size()]);
    }
}
