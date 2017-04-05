package me.rui.ds.sort;

import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/4/5.
 *  归并排序
 *  复杂度O(nlogn)
 *  稳定
 */
public class MergeSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private void mergeSort(Comparable[] a,Comparable[] aux, int left, int right) {
        if (right - left < 1) return;
        int mid = (left + right) / 2;
        mergeSort(a, aux,left, mid);
        mergeSort(a, aux, mid + 1, right);
        merge(a, aux, left, mid, right);
    }

    private void merge(Comparable[] a, Comparable[] aux, int left, int mid, int right) {
        for (int i=left; i<= right; i++) {
            aux[i] = a[i];
        }
        int pos1 = left;
        int pos2 = mid + 1;
        int pivotpos = left;
        while ((pos1 <= mid) && (pos2 <= right)) {
            // 此处注意，为确保稳定，条件应为aux[pos1] <= aux[pos2]
            if (!less(aux[pos2], aux[pos1])) a[pivotpos++] = aux[pos1++];
            else a[pivotpos++] = aux[pos2++];
        }
        while (pos1 <= mid) a[pivotpos++] = aux[pos1++];
        while (pos2 <= right) a[pivotpos++] = aux[pos2++];
    }
}
