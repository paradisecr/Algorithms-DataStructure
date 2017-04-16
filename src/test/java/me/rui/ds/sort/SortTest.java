package me.rui.ds.sort;

import org.junit.Assert;
import org.junit.Test;

import static me.rui.ds.sort.SortUtils.isSorted;
import static me.rui.ds.sort.SortUtils.randomSeq;
import static me.rui.ds.sort.SortUtils.shuffledSeq;

/**
 * Created by cr on 2017/3/31.
 */
public class SortTest {

    /**
     *  MSD基数排序测试
     */
    @Test
    public void msdTest() {
        Sortable sortable = new MSDSort();
        Integer[] a = shuffledSeq(100, 500);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    /**
     *  堆排序
     */
    @Test
    public void heapTest(){
        Sortable sortable = new HeapSort();
        Integer[] a = randomSeq(100, 1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest() {
        Sortable sortable = new BubbleSort();
        Integer[] a = randomSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    /**
     * 归并排序测试
     */
    @Test
    public void mergeSortTest() {
        Sortable sortable = new MergeSort();
        Integer[] a = randomSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }


    @Test
    public void quickInsertSort2Test() {
        Sortable sortable = new QuickInsertSort2();
        Integer[] a = randomSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }
    @Test
    public void quickInsertSortTest() {
        Sortable sortable = new QuickInsertSort();
        Integer[] a = randomSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void quickSortTest() {
        Sortable sortable = new QuickSort();
        Integer[] a = randomSeq(10,100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void selectionSortTest() {
        Sortable sortable = new Selection();
        Integer[] a = randomSeq(10,100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void insertSortTest() {
        Sortable sortable = new InsertSort();
        Integer[] a = randomSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void binaryInsertSortTest() {
        Sortable sortable = new BinaryInsertSort();
        Integer[] a = randomSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void shellSortTest() {
        Sortable sortable = new ShellSort();
        Integer[] a = randomSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }
}
