package me.rui.ds.sort;

import org.junit.Assert;
import org.junit.Test;

import static me.rui.ds.sort.SortUtils.isSorted;
import static me.rui.ds.sort.SortUtils.randowSeq;

/**
 * Created by cr on 2017/3/31.
 */
public class SortTest {

    @Test
    public void mergeSortTest() {
        Sortable sortable = new MergeSort();
        Integer[] a = randowSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void quickInsertSort2Test() {
        Sortable sortable = new QuickInsertSort2();
        Integer[] a = randowSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }
    @Test
    public void quickInsertSortTest() {
        Sortable sortable = new QuickInsertSort();
        Integer[] a = randowSeq(100,1000);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void quickSortTest() {
        Sortable sortable = new QuickSort();
        Integer[] a = randowSeq(10,100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void selectionSortTest() {
        Sortable sortable = new Selection();
        Integer[] a = randowSeq(10,100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void insertSortTest() {
        Sortable sortable = new InsertSort();
        Integer[] a = randowSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void binaryInsertSortTest() {
        Sortable sortable = new BinaryInsertSort();
        Integer[] a = randowSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void shellSortTest() {
        Sortable sortable = new ShellSort();
        Integer[] a = randowSeq(10, 100);
        sortable.sort(a);
        Assert.assertTrue(isSorted(a));
    }
}
