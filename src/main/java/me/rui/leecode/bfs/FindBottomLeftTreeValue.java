package me.rui.leecode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caorui on 2017/9/10.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left  != null) queue.add(root.left);
        }
        return root.val;
    }
}
