package me.rui.sword.greatcode;

/**
 * Created by cr on 2017/4/20.
 */
public class ReOrderArray {

    // 0. 最简单的方法，需辅助空间n,时间复杂度O(n)
    public void bestReOrderArray(int [] array) {
        if (null == array || array.length == 1) return;
        int[] aux = new int[array.length];
        int p = 0;
        int index = 0;
        while (p< array.length) {
            if (isOddNum(array[p])) aux[index++] = array[p];
            p++;
        }
        p = 0;
        while (p< array.length) {
            if (!isOddNum(array[p])) aux[index++] = array[p];
            p++;
        }
        p = 0;
        while (p < array.length) {
            array[p] = aux[p];
            p++;
        }
    }
    //1. 模仿插入排序的解法 O(n方)
    public void reOrderArray(int [] array) {
        if (null == array || array.length <=1) return;
        int i,j;
        // [0,i）有序，将i插入有序区
        for (i = 1; i<array.length; i++) {
            if (!isOddNum(array[i])) continue;
            j = i;
            int tmp = array[j];
            while(j > 0 && !isOddNum(array[j-1])) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
        }
    }
    // 2. 模仿归并排序的解法 O(nlgn)
    public void mergeReOrderArray(int [] array) {
        if (null == array || array.length == 1) return;
        int[] aux = new int[array.length];
        mergeReOrderArrayInternal(array, aux, 0, array.length - 1);
    }

    private void mergeReOrderArrayInternal(int[] array,int[] aux,  int left, int right) {
        // 1. divide
        if (right <= left) return;
        int mid = (left + right) /2;
        mergeReOrderArrayInternal(array,aux, left, mid);
        mergeReOrderArrayInternal(array,aux, mid+1, right);
        // 2. merge
        merge(array, aux, left, mid, right);
    }

    private void merge(int[] array,int[] aux,  int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int cur = left;
        while (p1 <= mid && isOddNum(array[p1])) aux[cur++] = array[p1++];
        while (p2 <= right && isOddNum(array[p2])) aux[cur++] = array[p2++];
        while (p1 <= mid) aux[cur++] = array[p1++];
        while (p2 <= right) aux[cur++] = array[p2++];
        for (cur = left; cur <= right; cur++) {
            array[cur] = aux[cur];
        }
    }


    private boolean isOddNum(int num) {
        return (num & 1) == 1;
    }
}
