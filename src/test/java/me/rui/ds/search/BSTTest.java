package me.rui.ds.search;

import me.rui.ds.sort.SortUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.List;

/**
 * Created by cr on 2017/4/13.
 *  二叉搜索树测试：
 *  1. 插入与查找
 *  3. 删除
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class BSTTest {
    @Test
    public void putAndGetTest() {
        BST<Integer, Integer> bst = new BST<>();
        // 1. 插入随机元素
        Integer[] keys = SortUtils.shuffledSeq(1, 10);
        for (Integer key : keys) {
            bst.put(key, key);
        }
        // 2. check 元素成功插入 && check get功能
        for (Integer key : keys) {
            assert key.equals(bst.get(key));
        }
        // 3.测试isSorted方法
        List<Integer> list = bst.toSortedList();
        Integer[] array = new Integer[list.size()];
        SortUtils.isSorted(list.toArray(array));
        // 4. check 元素是按照规则插入的
        assert bst.isSorted();
    }

    @Test
    public void removeTest() {
        BST<Integer, Integer> bst = new BST<>();
        Integer[] keys = new Integer[]{53, 78, 65, 17, 87, 9, 81, 45, 23};
        for (Integer key : keys) {
            bst.put(key, key);
        }
        // 1. 删除右子树为空的元素(45)
        bst.remove(45);
        assert bst.isSorted();
        // 2. 删除左右子树都不为空的元素(78)
        bst.remove(78);
        assert bst.isSorted();
    }

}
