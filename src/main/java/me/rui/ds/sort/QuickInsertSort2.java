package me.rui.ds.sort;

import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/4/4.
 *  第二种快速排序和插入排序的混合排序
 *  原理：1. 对于初始排列已经基本有序的序列，直接插入排序算法具有很高的效率；
 *        2. 对于长度小于M的子序列，不再partition。而是再最后整体执行一遍直接插入排序
 */
public class QuickInsertSort2 implements Sortable {

    public static int M = 5;

    @Override
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
        insertSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] a, int left, int right) {
        if (right - left > M) {
            int pivotpos = partition(a, left, right);
            quickSort(a, left, pivotpos - 1);
            quickSort(a, pivotpos + 1, right);
        }
    }

    private int partition(Comparable[] a, int left, int right) {
        int pivotpos = left;
        Comparable pivot = a[pivotpos];
        for (int i = left + 1; i <= right; i++) {
            if (less(a[i], pivot)) {
                pivotpos++;
                if (i != pivotpos) swap(a, i, pivotpos);
            }
        }
        swap(a, left, pivotpos);
        return pivotpos;
    }

    private void insertSort(Comparable[] a, int left, int right) {
        for (int i = left+1; i<= right; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i-1; j >= left && less(a[j+1], a[j]); j--) swap(a, j, j+1);
            a[j+1] = tmp;
        }
    }
}
