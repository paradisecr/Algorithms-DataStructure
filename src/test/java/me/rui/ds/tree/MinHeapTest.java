package me.rui.ds.tree;

import me.rui.ds.sort.InsertSort;
import me.rui.ds.sort.SortUtils;
import org.junit.Test;

/**
 * Created by cr on 2017/4/15.
 *  最小堆测试：
 *  1. 以已有随机数列初始化，测试是否有序：
 *     - 0个元素的序列，期望：有序；
 *     - 1个元素的序列。期望：有序；
 *     - 10个元素的序列，maxSize = 10:
 *          - 有序性： 有序；
 *          - 添加元素： 失败, size为10；
 *          - 删除10次堆顶元素，每次： 成功，size-1, 有序；
 *          - 再次删除， 失败，size为0， 有序；
 *     - 10个元素的序列，maxSize = 20;
 *          - 有序性：有序；
 *          - 添加10次元素，每次：成功，size+1, 有序；
 *  2. 初始化空的堆，指定大小10：
 *     - 插入 第1-10个元素，期望：成功，size++, 有序；
 *     - 插入第11个元素，期望：失败，size不变，有序
 *     - 删除10次，期望：成功，size--，有序；
 *     - 删除第11次，期望，失败，size不变，有序；
 *
 */
public class MinHeapTest {

    @Test
    public void existSeqTest() {
        // 1.
        MinHeap<Integer> minHeap = new MinHeap<>(new Integer[0],10);
        assert minHeap.size() == 0;
        assert minHeap.isMinHeap();
        // 2.
        Integer[] seq = new Integer[]{1};
        minHeap = new MinHeap<>(seq, 10);
        assert minHeap.size() == 1;
        assert minHeap.isMinHeap();
        // 3.
        seq = SortUtils.shuffledSeq(1, 10);
        minHeap = new MinHeap<>(seq, 9);
        assert minHeap.size() == 10;
        assert minHeap.isMinHeap();
        assert !minHeap.insert(11);
        assert minHeap.size() == 10;
        int size = minHeap.size();
        for (int i = 0; i< size; i++) {
            assert minHeap.removeMin();
            assert minHeap.size() == (size - i - 1);
            assert minHeap.isMinHeap();
        }
        assert !minHeap.removeMin();
        assert minHeap.size() == 0;
        assert minHeap.isMinHeap();
        // 4.
        seq = SortUtils.shuffledSeq(1, 10);
        minHeap = new MinHeap<>(seq, 20);
        assert minHeap.size() == 10;
        assert minHeap.isMinHeap();
        seq = SortUtils.shuffledSeq(11, 20);
        for (int i = 0; i< 10; i++) {
            assert minHeap.insert(seq[i]);
            assert minHeap.size() == i+10+1;
            assert minHeap.isMinHeap();
        }
        assert !minHeap.insert(21);
        assert minHeap.size() == 20;
        assert minHeap.isMinHeap();
    }

    @Test
    public void emptyTest() {
        MinHeap minHeap = new MinHeap(10);
        Integer[] seq = SortUtils.shuffledSeq(1, 10);
        for (int i = 0; i< seq.length; i++) {
            minHeap.insert(seq[i]);
            assert minHeap.size() == i+1;
            assert minHeap.isMinHeap();
        }
        InsertSort insertSort = new InsertSort();
        insertSort.sort(seq);
        assert !minHeap.insert(11);
        assert minHeap.size() == 10;
        assert minHeap.getMin().equals(seq[0]);
        for (int i = 0; i< seq.length; i++) {
            minHeap.removeMin();
            assert minHeap.size() == seq.length - i - 1;
            assert minHeap.isMinHeap();
        }
        assert !minHeap.removeMin();
        assert minHeap.size() == 0;
    }
}
