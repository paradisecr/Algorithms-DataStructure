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
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable tmp = a[i];
            int j = i-1;
            for ( ; j >=0 && less(tmp, a[j]); j--) a[j+1] = a[j];
            a[j+1] = tmp;
        }
    }
}
