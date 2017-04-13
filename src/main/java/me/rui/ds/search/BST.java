package me.rui.ds.search;

import me.rui.ds.sort.SortUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cr on 2017/4/13.
 *   二叉搜索树，或为空树，或具有以下性质：
 *   1. 每个结点都被一个唯一的key标识；
 *   2. 左子树(如果存在)上所有元素的关键码都小于根节点的关键码；
 *   3. 右子树(如果存在)上所有元素的关键码都大于根节点的关键码；
 *   4. 左子树和右子树也是二叉搜索树
 *
 *   实现三个重点操作：
 *   1. 插入put
 *   2. 查找get
 *   3. 删除remove
 */
public class BST<Key extends Comparable<Key>, Value> {
    private static final int REMOVE_LEFT = 0;
    private static final int REMOVE_RIGHT = 1;
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right; // 左子树和右子树指针，
        public Node(Key key, Value value, Node left , Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(Key key, Value value) {
            this(key, value, null, null);
        }
    }

    /**
     *  插入元素，关键码不能重复
     * @param key
     * @param value
     * @return
     */
    public boolean put(Key key, Value value) {
        if (key == null) return false;
        if (root == null) {
            root = new Node(key, value);
            return true;
        }
        return insert(root, key, value);
    }

    /**
     * 按照关键码查找元素
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) return null;
        Node node = search(root, key);
        if (node != null) return node.value;
        return null;
    }

    public boolean remove(Key key) {
        if (key == null || root == null) return false;
        return removeInternal(null, root, key, REMOVE_LEFT);
    }

    private boolean removeInternal(Node pre, Node cur, Key key, int removeDirection) {
        if (cur == null) return false;
        if (pre == null) {
            root = null;
            return true;
        }
        if (SortUtils.less(key, cur.key)) {
            // 小于当前节点，进入左子树删除
            return removeInternal(cur, cur.left, key,REMOVE_LEFT);
        } else if (SortUtils.more(key, cur.key)) {
            // 大于当前节点，进入右子树删除
            return removeInternal(cur, cur.right, key, REMOVE_RIGHT);
        } else {
            // 等于当前节点，分四种情况删除：
            // 1. 左子树为空：用右子女填补；
            // 2. 右子树为空：用左子女填补；
            // 3. 左右子女皆空，直接删除；
            // 4. 左右子女皆不为空。
            if (cur.left != null && cur.right != null) {
                // 左右子树皆不为空，以右子树中序遍历的第一个元素替换当前元素，再迭代删除中序遍历的第一个元素
                Node tmp = cur.right;
                Node tmpPre = cur;
                int tmpDirection = REMOVE_RIGHT;
                while (tmp.left != null) {
                    tmpPre = tmp;
                    tmp = tmp.left;
                    tmpDirection = REMOVE_LEFT;
                }
                cur.key = tmp.key;
                cur.value = tmp.value;
                return removeInternal(tmpPre, tmp, cur.key, tmpDirection);
            } else {
                if (cur.left == null) {
                    // 左子树为空
                    if (removeDirection == REMOVE_LEFT) {
                        pre.left = cur.right;
                    } else {
                        pre.right = cur.right;
                    }
                    return true;
                } else {
                    // 右子树为空
                    if (removeDirection == REMOVE_LEFT) {
                        pre.left = cur.left;
                    } else {
                        pre.right = cur.left;
                    }
                    return true;
                }
            }
        }
    }

    public boolean isSorted() {
        return  checkSortedInternal(root);
    }

    public List<Value> toSortedList() {
        List<Value> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    private void inOrderTraverse(Node cur, List<Value> list) {
        if (cur == null) return;
        inOrderTraverse(cur.left, list);
        list.add(cur.value);
        inOrderTraverse(cur.right, list);
    }

    private boolean checkSortedInternal(Node cur) {
        if (cur == null) return true;
        if (cur.left != null) {
            if (! SortUtils.less(cur.left.key, cur.key)) return false;
            if (!checkSortedInternal(cur.left)) return false;
        }
        if (cur.right != null) {
            if (! SortUtils.more(cur.right.key, cur.key)) return false;
            if (!checkSortedInternal(cur.right)) return false;
        }
        return true;
    }

    private boolean insert(Node cur, Key key, Value value) {
        if (cur.key.equals(key)) return false;
        if (SortUtils.less(key, cur.key)) {
            if (cur.left == null) {
                cur.left = new Node(key, value);
                return true;
            }
            return insert(cur.left, key, value);
        } else {
            if (cur.right == null) {
                cur.right = new Node(key, value);
                return true;
            }
            return insert(cur.right, key, value);
        }
    }

    private Node search(Node cur, Key key) {
        if (cur == null) return  null;
        if (cur.key.equals(key)) return cur;
        if (SortUtils.less(key, cur.key)) {
            return search(cur.left, key);
        } else {
            return search(cur.right, key);
        }
    }
    private Node binarySearch(Key key) {
        return null;
    }
}
