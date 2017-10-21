package me.rui.mi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caorui on 2017/6/29.
 */
public class DefiniteSumPathOfTree {


    public List<List<TreeNode>> getPaths(TreeNode root, int sum) {
        if (root == null) return null;
        List<List<TreeNode>> pathList = new ArrayList<>();
        TreeNode curNode = root;
        if (root.val == 0) {
//            pathList.add(Collections.list());
        }
        int leftSum = sum - root.val;
        return null;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
