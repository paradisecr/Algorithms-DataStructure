package me.rui.leecode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *    Created by caorui on 2017/10/7.
 */
public class HouseRobber3_2 {

    public int rob(TreeNode root) {
        int[] res =  robInternal(root);
        return Integer.max(res[0], res[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (null == root) return new int[2];
        int res[] = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        // 0. not rob root
        res[0] = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);
        // 1. rob root
        res[1] = root.val + left[0] +  right[0];
        return res;
    }

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
