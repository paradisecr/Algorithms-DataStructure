package me.rui.ds.sort;

import static me.rui.ds.sort.SortUtils.*;
/**
 * Created by cr on 2017/3/31.
 *
 *   折半插入排序：
 *   时间复杂度：O(nLogn)
 *   稳定排序
 *   查找速度比直接插入排序快
 */
public class BinaryInsertSort implements Sortable {
    @Override
    public void sort(Comparable[] a) {

        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 1. 折半找到插入位置, [0,i-1]之间为有序
            int low = 0;
            int high = i-1;
            int middle;
            Comparable tmp = a[i];
            while (low <= high) {
                middle = (low + high)/2;
                if (less(tmp, a[middle])) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            // 2. 将插入位置以后的元素后移(从后往前)
            for (int j = i -1 ; j>= low; j--) a[j+1] = a[j];
            a[low] = tmp;
        }
    }
}
