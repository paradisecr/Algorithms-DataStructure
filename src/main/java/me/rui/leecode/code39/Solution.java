package me.rui.leecode.code39;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr on 2017/4/4.
 */
public class Solution {
    static List<Node> nodeList = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 2, 3};
        int target = 7;
        System.out.print(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Node root = new Node(null, target, target);
        handle(root, candidates);
        for (Node leaf : nodeList) {
            result.add(parse(leaf));
        }
        return  result;
    }

    public static List<Integer> parse(Node leaf) {
        List<Integer> result = new ArrayList<>();
        while (leaf.pre != null) {
            result.add(leaf.sub);
            leaf = leaf.pre;
        }
        return result;
    }

    public static void handle(Node parent, int[] candidates) {
        for (int n : candidates) {
            if (parent.value - n >0) {
                if (n <= parent.sub) {
                    Node cur = new Node(parent, parent.value-n, n);
                    handle(cur, candidates);
                }
            }else if (parent.value - n ==0) {
                Node cur = new Node(parent, parent.value-n, n);
                nodeList.add(cur);
            }
        }
    }
    static class Node {
        public Node pre;
        public int value;
        public int sub;

        public Node(Node pre, int value, int sub) {
            this.pre = pre;
            this.value = value;
            this.sub = sub;
        }
    }
}

