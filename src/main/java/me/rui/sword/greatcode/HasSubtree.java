package me.rui.sword.greatcode;

import me.rui.sword.util.TreeNode;

/**
 * Created by cr on 2017/4/22.
 *  题目描述
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 *  注意：
 *  子结构，有可能B是A内部的一部分，不一定在边缘。
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) return false;
        return  traverseSubTree(root1, root2);
    }

    private boolean isSubTreeInternal(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1.val != root2.val) return false;
        return isSubTreeInternal(root1.left, root2.left) && isSubTreeInternal(root1.right, root2.right);
    }

    private boolean traverseSubTree(TreeNode root1, TreeNode root2) {
        if (isSubTreeInternal(root1, root2)) {
            return true;
        }
        if (root1.left != null && traverseSubTree(root1.left, root2)) {
            return true;
        }
        if (root1.right != null && traverseSubTree(root1.right, root2)) {
            return true;
        }
        return false;
    }
}
