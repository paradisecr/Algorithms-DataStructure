package me.rui.algorithm.dynamicprogramming;


/**
 * Created by cr on 2017/4/27.
 * 最长公共子序列问题
 *
 * 思路：
 * 1. 根据最优子结构性质，构建最优解的递归式
 *  定义:c[i,j] 标识Xi,Yj的LCS长度，则有，c[i][j] =
 *      若i=0,或j=0: 0
 *      若i,j>0，且xi = yj: c[i-1][j-1] + 1
 *      若i,j>0, 且xi!=yj:  max(c[i-1][j], c[i][j-1])
 */
public class LCSUp {
    public String lcs(String a, String b) {
        if (a == null || b == null) return null;
        if (a.isEmpty() || b.isEmpty()) return null;
        int m = a.length();
        int n = b.length();
        int[][] c = new int[m+1][n+1];
        int[][] trace = new int[m+1][n+1];
        StringBuffer buffer = new StringBuffer();
        int i,j;
        for (i = 0; i< m; i++) c[i][0] = 0;
        for (j = 0; j< n; j++) c[0][j] = 0;
        for (i = 0; i< m; i++) {
            for (j = 0; j <n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    c[i+1][j+1] = c[i][j] + 1;
                    trace[i+1][j+1] = 0;
                }else if (c[i+1][j] >= c[i][j+1]) {
                    c[i+1][j+1] = c[i+1][j];
                    trace[i+1][j+1] = 1;
                } else {
                    c[i+1][j+1] = c[i][j+1];
                    trace[i+1][j+1] = -1;
                }
            }
        }
        i = m;
        j = n;
        char[] result = new char[c[m][n]];
        int index = result.length -1;
        while (index >=0) {
            switch (trace[i][j]) {
                case 0:
                    result[index--] = a.charAt(i-1);
                    i--;
                    j--;
                    break;
                case 1:
                    j--;
                    break;
                case -1:
                    i--;
                    break;
                default:
                    return null;
            }
        }
        return String.valueOf(result);
    }

}
