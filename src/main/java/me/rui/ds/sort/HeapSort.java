package me.rui.ds.sort;

/**
 * Created by cr on 2017/4/16.
 *  平均时间复杂度:O(nlgn)
 *  不稳定
 */
public class HeapSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        // 初始化最大堆 O(n)
        for (int i = (a.length - 2)/2; i>=0; i--) {
            siftDown(a, i, a.length - 1);
        }
        // 堆排序，每次将堆定元素与末尾对调O(nlgn)
        for (int i =0; i< a.length - 1; i++) {
            SortUtils.swap(a, 0, a.length - 1 - i);
            siftDown(a, 0, a.length - 1 - i - 1);
        }
    }

    private void siftDown(Comparable a[], int start, int end) {
        int i = start;
        int j = 2*i + 1;
        Comparable tmp = a[i];
        while (j <= end) {
            if (j < end && SortUtils.more(a[j+1], a[j])) j++;
            if (SortUtils.more(a[j], tmp)) {
                a[i] = a[j];
                i = j;
                j = 2*i + 1;
                continue;
            }
            break;
        }
        a[i] = tmp;
    }
}
