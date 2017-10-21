package me.rui.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caorui on 2017/5/12.
 */

public class Solution {
    private Map<TreeNode, Integer> fMap = new HashMap<TreeNode, Integer>();
    private Map<TreeNode, Integer> gMap = new HashMap<TreeNode, Integer>();
    public int maxPathSum(TreeNode root) {
        return f(root);
    }

    public int f(TreeNode root) {
        if (root == null) return 0;
        int result = root.val;
        if (null == fMap.get(root)) {
            if (root.left == null && root.right == null) {
                result = root.val;
            } else if (root.left != null && root.right != null) {
                result = max(f(root.left), f(root.right), g(root.left) + g(root.right) + root.val);
            } else if (root.left != null) {
                if (f(root.left)> 0) {
                    result = f(root.left) + root.val;
                } else {
                    result = root.val;
                }

            } else {
                if (f(root.right) > 0) {
                    result = f(root.right) + root.val;
                } else {
                    result = root.val;
                }
            }
        } else {
            result = fMap.get(root);
        }
        return result;

    }

    public int g(TreeNode root) {
        if (root == null) return 0;
        int result;
        if (null == gMap.get(root)) {
            if (root.left != null && root.right != null) {
                result = max(root.left, root.right);
            } else if (root.left == null && root.right == null) {
                result = root.val;
            } else if (root.left != null) {
                if (g(root.left) > 0) {
                    result = root.val + root.left.val;
                } else {
                    result = root.val;
                }

            } else  {
                if (g(root.right) > 0) {
                    result = root.val + root.right.val;
                } else {
                    result = root.val;
                }
            }

        } else {
            result = gMap.get(root);
        }
        return result;
    }

    public int max(TreeNode n1, TreeNode n2) {
        int v1 = n1 == null ? 0 : n1.val;
        int v2 = n2 == null ? 0 : n2.val;
        return v1 > v2 ? v1 : v2;
    }

    public int max(int a, int b, int c) {
        int tmp = a;
        if (b > tmp) tmp = b;
        if (c > tmp) tmp = c;
        return tmp;
    }

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
