package me.rui.leecode.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caorui on 2017/10/7.
 */
public class WordSearch2 {
    private int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] wods = new String[] {"a","a"};
        WordSearch2 solution = new WordSearch2();
        System.out.println(solution.findWords(board, wods));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String str : words) {
            if (res.contains(str)) continue;
            if (findWord(board, str.toCharArray())) {
                res.add(str);
            }
        }
        return res;
    }

    public boolean findWord(char[][] board, char[] word) {
        // 1. find start digit index
        // 这一步其实不需要，直接对每个char开始dfs即可。
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        boolean[][] flags = new boolean[board.length][];
        for (int i = 0; i< board.length; i++) {
            flags[i] = new boolean[board[i].length];
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == word[0]) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // 2. dfs
        for (int i =0; i<rows.size(); i++) {
            if (findWordInternal(board, word,flags, 0, rows.get(i), cols.get(i))) return true;
            for (int m = 0; m< board.length; m++) {
                flags[m] = new boolean[board[m].length];
            }
        }
        return false;
    }

    public boolean findWordInternal(char[][] board, char[] word,boolean[][] flags, int pos, int row, int col) {
        if (pos >= word.length) {
            return true;
        }
        if (row >= board.length || row <0 || col < 0 || col >= board[row].length) return false;
        if (flags[row][col]) return false;
        if (board[row][col] != word[pos]) return false;
        flags[row][col] = true;
        for (int i = 0; i< dirs.length; i++) {
            if (findWordInternal(board, word,flags, pos+1,row + dirs[i][0],col + dirs[i][1] )) return true;
        }
        flags[row][col] = false;
        return false;
    }
}
