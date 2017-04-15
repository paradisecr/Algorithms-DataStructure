package me.rui.ds.tree;

import me.rui.ds.sort.SortUtils;

import java.util.Arrays;

/**
 * Created by cr on 2017/4/15.
 *  最小堆
 */
public class MinHeap<E extends Comparable> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private int currentSize;
    private int maxHeapSize;

    private Comparable[] elements;

    public MinHeap(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        this.elements = new Comparable[maxHeapSize];
    }

    public MinHeap(Comparable[] elements, int maxHeapSize) {
        this.maxHeapSize = (maxHeapSize > elements.length) ? maxHeapSize:elements.length;
        this.elements = Arrays.copyOf(elements, this.maxHeapSize);
        this.currentSize = elements.length;
        //从最后一个分支结点[currentSize - 1 - 1]起向前sitfDown调整
        int curPos = (currentSize - 2)/2;
        while (curPos >= 0 ) siftDown(curPos--, currentSize - 1);
    }

    public E getMin(){
        if (currentSize == 0) return null;
        return (E) elements[0];
    }

    /**
     * 添加元素：先追加到末尾，再向上调整
     * @param e
     * @return
     */
    public boolean insert(E e) {
        if (currentSize == maxHeapSize) return false;
        elements[currentSize++] = e;
        siftUp(currentSize - 1);;
        return true;
    }

    /**
     * 删除位于堆顶的最小元素：先将末尾元素取代堆顶元素，然后从堆顶开始向下调整。
     * @return
     */
    public boolean removeMin() {
        if (currentSize == 0) return false;
        elements[0] = elements[currentSize -1];
        currentSize--;
        siftDown(0, currentSize  - 1);
        return true;
    }

    public boolean isMinHeap() {
        return isMinHeapInternal(0);
    }

    public int size() {
        return this.currentSize;
    }

    private boolean isMinHeapInternal(int pos) {
        int l = pos * 2 + 1;
        int r = pos * 2 + 2;
        if (l <= currentSize - 1) {
            if (SortUtils.more(elements[pos], elements[l])) return false;
            if (!isMinHeapInternal(l)) return false;
        }
        if (r <= currentSize - 1) {
            if (SortUtils.more(elements[pos], elements[r])) return false;
            if (!isMinHeapInternal(r)) return false;
        }
        return true;
    }

    /**
     * 向下调整
     * @param start
     * @param end
     */
    private void siftDown(int start, int end) {
        int i = start;
        int j = 2 * i + 1;
        Comparable tmp = elements[i];
        while(j <= end) {
            if (j < end && SortUtils.less(elements[j + 1], elements[j])) j++;
            if (SortUtils.less(elements[j], tmp)) {
                elements[i] = elements[j];
                i = j;
                j = 2*i+1;
                continue;
            }
            break;
        }
        elements[i] = tmp;
    }

    /**
     * 向上调整
     * @param start
     */
    private void siftUp(int start) {
        int i = start;
        int j = (i - 1) / 2;
        Comparable tmp = elements[i];
        while (i > 0 ) { // 此判定条件很重要
            if (SortUtils.less(tmp,elements[j])) {
                elements[i] = elements[j];
                i = j;
                j = (i -1)/2;
                continue;
            }
            break;
        }
        elements[i] = tmp;
    }
}
