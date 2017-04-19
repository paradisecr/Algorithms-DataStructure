package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/19.
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：从右上角开始搜索，比较该数字与目标：
 *   若相等，结束；
 *   若大于，删除该列；
 *   若小于，删除该行；
 */
public class FindInPartiallySortedMatrix {
    public boolean find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int curRow = 0;
        int curCol = cols - 1;
        while (curRow < rows && curCol >=0) {
            if (array[curRow][curCol] == target) return true;
            if (array[curRow][curCol] > target) {
                curCol--;
            } else {
                curRow ++;
            }
        }
        return false;
    }
}
