package me.rui.sword.greatidea;

import me.rui.sword.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr on 2017/4/23.
 *  题目描述
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *  思路：中序遍历。
 *  方法2更加简洁明了。
 */
public class Convert {
    TreeNode lastNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        List<TreeNode> list = new ArrayList<>();
        inTraverse(pRootOfTree, list);
        if (list.isEmpty()) return null;
        TreeNode root = list.get(0);
        for (int i = 0; i< list.size() -1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return root;
    }

    public TreeNode convert2(TreeNode pRootOfTree) {
        if (null == pRootOfTree) return null;
        TreeNode root;
        inTraverse2(pRootOfTree);
        root = lastNode;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private void inTraverse(TreeNode node, List<TreeNode> list) {
        if (null == node) return;;
        inTraverse(node.left, list);
        list.add(node);
        inTraverse(node.right, list);
    }

    private void inTraverse2(TreeNode node) {
        if (null == node) return;
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        // 1,遍历左子树
        inTraverse2(leftNode);
        // 2.visit当前节点
        // :与最后一个节点建立前后链接，并表示curNode为最后节点
        if (null != lastNode) {
            lastNode.right = node;
            node.left = lastNode;
        }
        lastNode = node;
        // 3.遍历右子树
        inTraverse2(rightNode);
    }

}
