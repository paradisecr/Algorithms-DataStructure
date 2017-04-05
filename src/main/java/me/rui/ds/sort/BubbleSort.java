package me.rui.ds.sort;
import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/4/5.
 *   冒泡排序
 *   复杂度O(n方)
 *   稳定
 */
public class BubbleSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {
        // [0,i)有序，且比[i, length] 小
        for (int i= 1; i < a.length; i++) {
            // 从后往前冒泡
            for (int j = a.length - 1; j >= i; j--) {
                if (less(a[j], a[j-1])) swap(a, j , j-1);
            }
        }
    }
}
