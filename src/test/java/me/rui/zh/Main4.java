package me.rui.zh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
            String s = sc.nextLine();
            int f = Integer.parseInt(num);
            String[] ss = s.split(" ");
            Map<Integer, List<String>> map = new TreeMap<>();
            int[] ii = new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                if (ss[i].length() >= 3) {
                    ii[i] = Integer.parseInt(ss[i].substring(ss.length - 3));
                    if (map.containsKey(ii[i])) {
                        List<String> list = map.get(ii[i]);
                        if (ss[i].substring(ss.length - 3, ss.length - 2).equals("0")) {
                            list.add(ss[i].substring(0, ss.length - 2));
                        }else{
                            list.add(ss[i].substring(0, ss.length - 3));
                        }
                        map.put(ii[i], list);
                    } else {
                        List<String> list = new ArrayList<>();
                        if (ss[i].substring(ss.length - 3, ss.length - 2).equals("0")) {
                            list.add(ss[i].substring(0, ss.length - 2));
                        }else{
                            list.add(ss[i].substring(0, ss.length - 3));
                        }
                        map.put(ii[i], list);
                    }
                } else {
                    ii[i] = Integer.parseInt(ss[i]);
                    if (map.containsKey(ii[i])) {
                        List<String> list = map.get(ii[i]);
                        list.add("");
                        map.put(ii[i], list);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add("");
                        map.put(ii[i], list);
                    }
                }
            }
            Arrays.sort(ii);
            int temp = 0;
            for (Entry<Integer, List<String>> entry : map.entrySet()) {
                List<String> list = entry.getValue();
                while (f > 0) {
                    temp = f;
                    f -= list.size();
                    break;
                }
                if (f <= 0) {
                    for (int k = 0; k < list.size(); k++) {
                        if (k == temp - 1) {
                            System.out.println(list.get(k) + entry.getKey());
                            return;
                        }
                    }
                }

            }
    }
}