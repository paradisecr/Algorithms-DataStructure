package me.rui.leecode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caorui on 2017/9/9.
 */
public class Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 队列存储会影响附近距离的点的坐标
        Queue<int []> queue = new LinkedList<>();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                // 更新临近节点的距离
                if (r<0 || r>=rows || c <0 || c >=cols ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
                queue.add(new int[] { r, c});
            }
        }
        return matrix;
    }
}
