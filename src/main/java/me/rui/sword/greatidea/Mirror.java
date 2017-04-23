package me.rui.sword.greatidea;

import me.rui.sword.util.TreeNode;

/**
 * Created by cr on 2017/4/22.
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 注意递归的返回条件。
 */
public class Mirror {
    public void mirror(TreeNode root) {
        if (null == root) return;;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }
}
