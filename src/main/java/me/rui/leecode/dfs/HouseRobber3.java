package me.rui.leecode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *    Created by caorui on 2017/10/7.
 */
public class HouseRobber3 {

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (null == root) return 0;
        if (map.containsKey(root)) return map.get(root);
        int res=0, bRes=0, nRes=0;
        // 1. broke
        bRes += root.val;
        if (null != root.left) {
            bRes += rob(root.left.left,map);
            bRes += rob(root.left.right,map);
        }
        if (null != root.right) {
            bRes += rob(root.right.left,map);
            bRes += rob(root.right.right,map);
        }
        // 2. not broke
        nRes += rob(root.left,map);
        nRes += rob(root.right,map);
        // 3. select_max(broke_result, not_broke_result)
        res = Integer.max(bRes, nRes);
        map.put(root, res);
        return res;
    }

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
