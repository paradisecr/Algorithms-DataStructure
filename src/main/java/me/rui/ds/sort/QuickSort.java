package me.rui.ds.sort;

import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/4/4.
 *   快速排序
 *   不稳定
 *   平均复杂度O(nlogn)
 *
 */
public class QuickSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        // sortInternal
        sortInternal(a, 0, a.length - 1);
    }

    private void sortInternal(Comparable[] a, int left, int right) {
        if ( left < right) {
            // 1. partition, return pivot position
            int pivotpos = partition(a, left, right);
            // 2. sort left
            sortInternal(a, left, pivotpos - 1);
            // 3. sort right
            sortInternal(a, pivotpos + 1, right);
        }
    }

    /**
     * 使用第一个元素最为基准元素划分为左右两个序列
     * 左侧：小于基准元素
     * 右侧：大于等于基准元素
     * @param a
     * @param low
     * @param high
     * @return pivotpos: 返回划分后基准元素位置
     */
    private int partition(Comparable[] a, int low, int high) {
        int pivotpos = low;
        Comparable pivot = a[low];
        // 从left+1到逐一处理
        for (int i = low +1; i <= high; i++) {
            if (less(a[i], pivot)) {
                pivotpos++;
                if (i != pivotpos) swap(a, pivotpos, i);
            }
        }
        swap(a, low, pivotpos);
        return pivotpos;
    }
}
