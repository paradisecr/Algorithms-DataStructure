package me.rui.ds.sort;

import java.util.Arrays;

/**
 * Created by cr on 2017/4/16.
 *  MSD基数排序
 */
public class MSDSort implements Sortable{

    private static final int M = 10; // 长度小于此的序列使用插入排序
    private static final int RADIX = 10;
    private InsertSort insertSort = new InsertSort();
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=0) return;
        if (!(a[0] instanceof Integer)) return;
        Integer[] auxArray = new Integer[a.length];
        for (int i=0; i< a.length; i++) {
            auxArray[i] = (Integer) a[i];
        }
        sortInternal(auxArray, 0, auxArray.length - 1, 3);
        for (int i = 0; i< auxArray.length; i++) {
            a[i] = auxArray[i];
        }
    }

    private void sortInternal(Integer[] a, int left, int right, int d) {
        // 1. 扫描，按照第i位的数字统计桶元素个数，使用辅助数组count
        // 2. 将待排序元素按照第i为数字分配到桶中，使用辅助数组auxArray;
        // 3. 将桶写回原数组;
        // 4. 对每个桶内元素进行排序
        if (d <=0 ) return;
        if (right - left + 1 <= M) {
            insertSort.sort(a, left, right);
            return;
        }
        int i, k;
        int[] count = new int[RADIX];
        int[] auxArray = new int[right - left + 1];
        for (i = 0; i< RADIX; i++) count[i] = 0;
        for (i = left; i<= right; i++) {
            k = getDigit( a[i], RADIX, d);
            count[k]++;
        }
        for (i = 1; i < RADIX; i++) count[i] = count[i] + count[i-1];
        for (i = left; i<= right; i++) {
            k = getDigit(a[i], RADIX, d);
            auxArray[--count[k]] = a[i];
        }
        for (i = 0; i < auxArray.length; i++) a[i + left] = auxArray[i];
        for (i = 0; i< RADIX; i++) {
            int p1 = count[i];
            int p2;
            if (i < RADIX - 1) {
                p2 = count[i+1] - 1;
            } else {
                p2 = right - left;
            }
            if (p2 < p1 ) continue;
            sortInternal(a, left+p1, left + p2, d-1);
        }
    }

    /**
     * 取某一位数值
     * @param num
     * @param d
     * @return
     */
    private int getDigit(int num,int radix, int d) {
        while (d > 1) {
            num = num / radix;
            d--;
        }
        return num % radix;
    }

//    public boolean isSorted(Comparable a[]) {
//        if (null == a || a.length <= 1) return true;
//        for (int i = 0; )
//    }
}
