package me.rui.sword.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr on 2017/4/20.
 *  重建二叉树
 *
 *  题目描述:
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTreeInternal(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeInternal(int [] pre,int preLeft, int preRight, int [] in, int inLeft, int inRight) {

        // 1. 找root
        int rootVal = pre[preLeft];
        int inRootIndex = partition(pre[preLeft], in, inLeft, inRight);
        TreeNode root = new TreeNode(rootVal);
        int leftNodeNum = inRootIndex - inLeft ;
        int rightNodeNum = inRight - inRootIndex;
        // 2. 找左边子序列root
        if (leftNodeNum > 0) {
            TreeNode left = reConstructBinaryTreeInternal(pre, preLeft + 1, preLeft + leftNodeNum, in, inRootIndex - leftNodeNum, inRootIndex - 1);
            root.left  = left;
        }

        // 3. 找右边子序列root
        if (rightNodeNum > 0) {
            TreeNode right = reConstructBinaryTreeInternal(pre, preLeft + leftNodeNum + 1,preLeft + leftNodeNum + rightNodeNum, in, inRootIndex + 1, inRootIndex + rightNodeNum);
            root.right = right;
        }
        return root;
    }

    private int partition(int target, int[] array, int start, int end) {
        for (int i = start; i<= end; i++) {
            if (target == array[i]) return i;
        }
        return -1;
    }

    public int[] preTraverse(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        preTraverseInternal(node, list);
        Integer[] tmp = new Integer[list.size()];
        int[] result = new int[tmp.length];
        list.toArray(tmp);
        for (int i = 0; i< result.length; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    private void preTraverseInternal(TreeNode node, List<Integer> list) {
        if (null == node) return ;
        list.add(node.val);
        preTraverseInternal(node.left, list);
        preTraverseInternal(node.right, list);
    }

    public int[] inTraverse(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inTraverseInternal(node, list);
        Integer[] tmp = new Integer[list.size()];
        int[] result = new int[tmp.length];
        list.toArray(tmp);
        for (int i = 0; i< result.length; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    private void inTraverseInternal(TreeNode node, List<Integer> list) {
        if (null == node) return ;
        inTraverseInternal(node.left, list);
        list.add(node.val);
        inTraverseInternal(node.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
