package me.rui.sword.greatidea;

import java.util.*;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路：
 * 注意容器使用时的判空。
 */
public class GetLeastNumbersSolution {
    class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public ArrayList<Integer> getLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == input || input.length == 0 || k <= 0 || k > input.length) return list;
        if (k == input.length) {
            for (int num : input) {
                list.add(num);
            }
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        for (int num : input) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
                continue;
            }
            if (maxHeap.peek() > num) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        list.addAll(maxHeap);
        return list;
    }
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == input || input.length == 0 || k <= 0 || k > input.length) return list;
        if (k == input.length) {
            for (int num : input) {
                list.add(num);
            }
            return list;
        }
        // 使用容量为K的容器存储最小的4个数
        Set<Integer> kSet = new HashSet<>();
        // 用栈记录容器中最大的元素
        Stack<Integer> maxStack = new Stack<>();
        int max = 0;
        // 遍历数组：
        // 若容器元素数小于k，则直接进入容器，并更新stack
        // 若当前元素小于容器中最大元素，则替换容器最大元素，并更新stack
        for (int num : input) {
            if (kSet.isEmpty()) {
                max = num;
                kSet.add(num);
                maxStack.push(max);
                continue;
            }
            if (kSet.size() < k) {
                if (num > max) max = num;
                kSet.add(num);
                maxStack.push(max);
                continue;
            }
            if (num < max) {
                kSet.remove(max);
                maxStack.pop();
                kSet.add(num);
                if (maxStack.isEmpty() || num > maxStack.peek()) {
                    max = num;
                } else {
                    max = maxStack.peek();
                }
                maxStack.push(max);
            }
        }
        list.addAll(kSet);
        return list;
    }
}
