package me.rui.ds.sort;

/**
 * Created by cr on 2017/4/4.
 *   快速排序、插入排序混合方法
 *   原理：当序列长度M取值为5-25时，采用直接插入排序要比快速排序至少快10%
 *         这里，在快速排序过程中，当子序列规模较小时，直接调用插入排序。
 */
public class QuickInsertSort implements Sortable {
    public static int M = 5;
    @Override
    public void sort(Comparable[] a) {
        quickInsertSort(a, 0, a.length - 1);
    }

    private void quickInsertSort(Comparable[] a, int left, int right) {
        // 1. 如果子序列较小，直接使用插入排序
        if (right - left <= M) {
            insertSort(a, left, right);
        } else {
            int pivotpos = partition(a, left, right);
            quickInsertSort(a, left, pivotpos - 1);
            quickInsertSort(a, pivotpos + 1, right);
        }
    }

    private void insertSort(Comparable[] a, int left, int right) {
        // 第i趟时，[0,i-1]有序，在有序中为i找合适的位置
        for (int i = left + 1; i <= right; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i -1; j>=left && SortUtils.less(a[j+1], a[j]); j--) SortUtils.swap(a, j, j+1);
            a[j+1] = tmp;
        }
    }

    private int partition(Comparable[] a, int low, int high) {
        // 将第一个元素作为基准元素
        Comparable pivot = a[low];
        int pivotpos = low;
        for (int i = low + 1; i <= high; i++) {
            // 在i处发现一个小于基准元素的元素，将pivotpos++,然后将此元素放在pivotpos
            if (SortUtils.less(a[i], pivot)) {
                pivotpos++;
                if (pivotpos != i) {
                    SortUtils.swap(a, pivotpos, i);
                }
            }
        }
        // 将基准元素放在pivotpos
        SortUtils.swap(a, low, pivotpos);
        return pivotpos;
    }
}
