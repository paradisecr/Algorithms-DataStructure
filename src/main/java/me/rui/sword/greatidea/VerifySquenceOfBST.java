package me.rui.sword.greatidea;

/**
 * Created by cr on 2017/4/23.
 *  题目描述
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *  思路：递归式，注意情形分类。
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (null == sequence || sequence.length <1) return false;
        return isBSTSeq(sequence, 0, sequence.length - 1);
    }

    private boolean isBSTSeq(int[] seq, int left, int right) {
        if (right - left <=1) return true;
        int root = seq[right];
        int mid = partition(seq,left,right-1, root);
        // 左空, mid < left;
        if (mid < left) {
            if (isSorted(seq, left, right - 1,root, -1)) {
                return isBSTSeq(seq, left, right-1);
            }
            return false;
        }
        // 右空, mid > right -1;
        if (mid > right-1) {
            if (isSorted(seq, left, right -1, root, 1)) {
                return isBSTSeq(seq, left, right-1);
            }
            return false;
        }
        // 都不空,  left <= mid < right-1
        if(isSorted(seq, left, mid, root, 1) && isSorted(seq, mid+1, right-1, root, -1)) {
            return isBSTSeq(seq, left, mid) && isBSTSeq(seq, mid+1, right-1);
        }
        return false;
    }

    private int partition(int[] seq,int left, int right, int num) {
        for (int i = left; i<= right; i++) {
            if (seq[i] > num) return i-1;
        }
        return right;
    }
    private boolean isSorted(int[] seq,int left,int right, int num,int flag) {
        for (int i = left; i<=right; i++) {
            if ((num - seq[i]) * flag < 0) return false;
        }
        return true;
    }
}
