package me.rui.sword.greatidea;

import me.rui.sword.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 注意：list.addAll()参数不能为空。
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results;
        results =  findPathInternal(root, target);
        if (null == results) results = new ArrayList<>();
        for (ArrayList<Integer> list : results) {
            Collections.reverse(list);
        }
        return results;
    }

    private ArrayList<ArrayList<Integer>> findPathInternal(TreeNode root, int remain) {
        if (null == root) return null;
        if (remain < root.val) return null;
        ArrayList<Integer> list;
        ArrayList<ArrayList<Integer>> results = null;
        if (remain == root.val && root.left == null && root.right == null) {
            list = new ArrayList<>();
            list.add(root.val);
            results = new ArrayList<>();
            results.add(list);
            return results;
        }
        ArrayList<ArrayList<Integer>> leftResults;
        ArrayList<ArrayList<Integer>> rightResults;
        leftResults = findPathInternal(root.left, remain - root.val);
        rightResults = findPathInternal(root.right, remain - root.val);
        if (null != leftResults) results = leftResults;
        if (null == results) {
            if (null == rightResults) return null;
            results = rightResults;
        } else {
            if (null != rightResults) {
                results.addAll(rightResults);
            }
        }
        for (ArrayList<Integer> arrayList : results) {
            arrayList.add(root.val);
        }
        return results;
    }
}
