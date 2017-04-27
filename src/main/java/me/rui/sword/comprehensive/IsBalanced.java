package me.rui.sword.comprehensive;

import me.rui.sword.util.TreeNode;

/**
 * Created by cr on 2017/4/24.
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 * 要避免重复访问节点。
 */
public class IsBalanced {
    boolean isBalance = true;
    public boolean isBalance(TreeNode root) {
        traverse(root);
        return isBalance;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        if (!isBalance) {
            return 0;
        }
        int right = traverse(root.right);
        if ( Math.abs(left - right) >1) isBalance = false;
        return left > right ? left+1: right+1;
    }
}
