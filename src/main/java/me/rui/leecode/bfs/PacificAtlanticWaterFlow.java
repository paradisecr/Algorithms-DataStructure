package me.rui.leecode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by caorui on 2017/9/10.
 */
public class PacificAtlanticWaterFlow {
    private int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i=0; i< m; i++) {
            pQueue.add(new int[] {i,0});
            aQueue.add(new int[] {i,n-1});
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }
        for (int j=0; j<n; j++) {
            pQueue.add(new int[] {0,j});
            aQueue.add(new int[] {m-1, j});
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(new int[] {i,j});
            }
        }
        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean visited[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r<0 || r>=m|| c<0 || c>=n ||
                        visited[r][c] || matrix[r][c] < matrix[cur[0]][cur[1]]) continue;
                visited[r][c] = true;
                queue.offer(new int[] {r,c});
            }
        }
    }
}
