package me.rui.leecode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by caorui on 2017/9/10.
 */

public class FindLargestValueInEachRow {

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        if (d == res.size()) {
            res.add(root.val);
        } else {
            res.set(d, Math.max(root.val, res.get(d)));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }

    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) return result;
        Queue<TreeNode> curQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        Queue<TreeNode> tmp;
        curQueue.add(root);
        int max = Integer.MIN_VALUE;
        TreeNode curNode;
        while (!curQueue.isEmpty() ) {
            max = Integer.MIN_VALUE;
            while (!curQueue.isEmpty()) {
                curNode = curQueue.poll();
                max = curNode.val > max ? curNode.val : max;
                if (curNode.left != null) nextQueue.add(curNode.left);
                if (curNode.right != null) nextQueue.add(curNode.right);
            }
            result.add(max);
            tmp = curQueue;
            curQueue = nextQueue;
            nextQueue = tmp;
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
