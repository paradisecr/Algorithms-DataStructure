package me.rui.ds.sort;

import static me.rui.ds.sort.SortUtils.*;

/**
 * Created by cr on 2017/3/31.
 *  选择排序
 *  不稳定
 *  复杂度：O(n方)
 */
public class Selection implements Sortable{

    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i=0;i<n; i++) {
            // [0,i)为有序，从[i,length]中选择最小的元素，与i对调
            int min = i;
            for (int j = i+1; j<n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
        }
    };
}
