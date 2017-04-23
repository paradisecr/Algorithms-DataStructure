package me.rui.sword.greatidea;

import java.util.ArrayList;
/**
 * Created by cr on 2017/4/22.
 *  题目描述
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *  例如，如果输入如下矩阵：
 *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *  注意：控制转向以及停止条件。
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == matrix) return list;

        int left, right, up, down, i, j;
        left = 0;
        up = 0;
        down = matrix.length - 1;
        right = matrix[0].length - 1;
        while (left <= right && up <= down) {
            // 从左到右
            i = up;
            for (j = left; j<= right; j++) {
                list.add(matrix[i][j]);
            }
            // 从右到下
            j = right;
            for (i = up + 1; i<= down; i++) {
                list.add(matrix[i][j]);
            }
            // 从右下到左下
            if (down > up) {  // 重要的判断
                i = down;
                for (j = right - 1; j>= left; j--) {
                    list.add(matrix[i][j]);
                }
            }

            // 从左下到左上
            if (left < right) {  // 重要的判断
                j = left;
                for (i = down - 1; i>= up + 1; i--){
                    list.add(matrix[i][j]);
                }
            }

            left++;
            right--;
            up++;
            down--;
        }
        return list;
    }
}
