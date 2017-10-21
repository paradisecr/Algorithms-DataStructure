package me.rui.leecode.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caorui on 2017/10/7.
 */
public class WordSearch2_2 {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] wods = new String[] {"oath","pea","eat","rain"};
        WordSearch2_2 solution = new WordSearch2_2();
        System.out.println(solution.findWords(board, wods));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        // 1. build word trie
        TrieNode root = buildTrieNode(words);
        // 2. dfs chars in board, find words that can access
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, TrieNode root, List res) {
        char c = board[row][col];
        if (c == '#' || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;  // de-multiwords
        }
        board[row][col] = '#';
        if (col > 0) dfs(board, row, col - 1, root, res);
        if (row > 0) dfs(board, row - 1, col, root, res);
        if (col < board[row].length - 1) dfs(board, row, col+1,root, res);
        if (row < board.length - 1) dfs(board, row + 1, col, root, res);
        board[row][col] = c;
    }

    private TrieNode buildTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
