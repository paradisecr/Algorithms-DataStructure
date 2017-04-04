package me.rui.ds.sort;

/**
 * Created by cr on 2017/4/1.
 *   希尔排序
 *   时间复杂度：约为O(n方)
 *   不稳定
 */
public class ShellSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        int gap = a.length;
        int n = a.length;
        while (gap > 1) {
            gap = gap/3 + 1;
            for (int i=gap; i<n; i++) {
                int j;
                Comparable tmp = a[i];
                for (j= i-gap; j >= 0 && SortUtils.less(a[j+gap], a[j]); j--) {
                    SortUtils.swap(a, j, j+gap);
                }
                a[j+gap] = tmp;
            }
        }
    }
}
