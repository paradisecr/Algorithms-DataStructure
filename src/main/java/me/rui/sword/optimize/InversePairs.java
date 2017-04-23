package me.rui.sword.optimize;

/**
 * Created by cr on 2017/4/23.
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 注意：得防止超过int范围。
 */
public class InversePairs {
    public int inversePairs(int [] array) {
        if (null == array || array.length == 0) return 0;
        int[] aux = new int[array.length];
        int count = merge(array, aux, 0, array.length-1);
        return count % 1000000007;
    }

    private int merge(int[] array,int[] aux, int left, int right) {
        if (right - left < 1) return 0;
        int mid = (left + right) / 2;
        int lc = merge(array, aux, left, mid) % 1000000007;
        int rc = merge(array, aux, mid+1, right) % 1000000007;
        return mergeArray(array, aux, left, mid, right) + lc + rc;
    }
    private int mergeArray(int[] array, int[] aux, int left, int mid, int right) {
        for (int i=left; i<= right; i++) {
            aux[i] = array[i];
        }
        int p1 = left;
        int p2 = mid + 1;
        int cur = left;
        int count = 0;
        while (p1 <= mid && p2 <= right) {
            if (aux[p2] < aux[p1]) {
                count += p2 - cur;
                if (count > 1000000007) count = count - 1000000007;
                array[cur++] = aux[p2++];
            } else {
                array[cur++] = aux[p1++];
            }
        }
        while (p1 <= mid) {
            array[cur++] = aux[p1++];
        }
        while (p2 <= right) {
            array[cur++] = aux[p2++];
        }
        if (count > 1000000007) count = count - 1000000007;
        return count;
    }
}
