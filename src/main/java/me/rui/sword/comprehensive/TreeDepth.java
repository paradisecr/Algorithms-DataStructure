package me.rui.sword.comprehensive;

import me.rui.sword.util.TreeNode;

/**
 * Created by cr on 2017/4/24.
 *
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路：
 * 很好的递归示范。
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (null == root) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return  left > right ? left+1: right + 1;
    }
}
