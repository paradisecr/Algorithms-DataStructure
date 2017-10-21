package me.rui.leecode.subarray;

import java.util.*;

/**
 * Created by caorui on 2017/9/5.
 */
public class Main2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] a1 = new int[] {1,2,3};
        int[] a2 = new int[] {2};
        int[] a3 = new int[] {1};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(2);
        list3.add(1);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(solution(2,2,3,lists));
    }
    public static int solution(int rows, int columns, int numOfFriends, List<List<Integer>> choiceList){
        // 每个蛋糕的需求量
        Map<Integer, Integer> indexCountMap =new HashMap<Integer, Integer>();
        // 每个人的可选数量
        Map<Integer, Integer> needCountMap =  new HashMap<Integer, Integer>();
        // 每个蛋糕可分配的人
        Map<Integer, Set<Integer>> needSetMap = new HashMap<Integer, Set<Integer>>();
        // 人可分配的蛋糕
        Map<Integer, Set<Integer>> dangaoMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i< numOfFriends; i++) {
            List<Integer> list = choiceList.get(i);
            dangaoMap.put(i, new HashSet<Integer>());
            for(Integer need : list) {
                indexCountMap.put(need, indexCountMap.getOrDefault(need,0) + 1);
                if (!needSetMap.containsKey(need)) needSetMap.put(need, new HashSet<Integer>());
                needSetMap.get(need).add(i);
                dangaoMap.get(i).add(need);
            }
            needCountMap.put(i, list.size());
        }
        int count = 0;
        while (true) {
            // find min need
            int index = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            // 选人
            for (Map.Entry<Integer, Set<Integer>> entry: dangaoMap.entrySet()) {
                if (entry.getValue().size() < min) {
                    min = entry.getValue().size();
                    index = entry.getKey();
                }
            }
            if (index == Integer.MAX_VALUE) break;
            // 选蛋糕

            min = Integer.MAX_VALUE;
            int index2 = Integer.MAX_VALUE;
            for (Integer dangao : dangaoMap.get(index)) {
                if(!needSetMap.containsKey(dangao)) continue;
                if (needSetMap.get(dangao).size() < min) {
                    min = needSetMap.get(dangao).size();
                    index2 = dangao;
                }
            }
            if (index2 == Integer.MAX_VALUE) break;
            count++;
            //分配蛋糕
            Set<Integer> dgSet = dangaoMap.remove(index);
            for (Integer dg : dgSet) {
                needSetMap.get(dg).remove(index);
            }
        }
        return count++;
    }
}
