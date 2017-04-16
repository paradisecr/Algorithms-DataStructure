package me.rui.ds.sort;
import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/3/31.
 *  直接插入排序
 *  时间复杂度：O(n方)
 *  稳定排序
 */
public class InsertSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        if (null == a || a.length <=0) return;
        sort(a, 0, a.length - 1);
    }
    public void sort(Comparable[] a, int left, int right) {
        int n = a.length;
        for (int i = left + 1; i <= right; i++) {
            Comparable tmp = a[i];
            int j = i-1;
            while (j>= left && less(tmp, a[j])) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = tmp;
        }
    }
}
