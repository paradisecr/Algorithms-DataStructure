package me.rui;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by cr on 2017/3/30.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();
        int  m = scanner.nextInt();
        // 1. 读取所有句子
        scanner.nextLine();
        String[] para = new String[n];
        for (int i=0; i< n; i++) {
            para[i] = scanner.nextLine();
        }
        Set<String>[] sets = new Set[n];
        // 2. 将句子拆散为单词，防到set中
        for (int i=0; i< para.length; i++) {
            String sent = para[i];
            String[] words = sent.split(" ");
            for (int j=0; j< words.length; j++) {
                String word = words[j].toLowerCase().trim();
                if (sets[i] == null) sets[i] = new HashSet<String>();
                sets[i].add(word);
            }
        }
        // 3.一次匹配目标句子
        for (int k=0; k< m; k++) {
            String tgt = scanner.nextLine();
            int maxIndex = parse(sets, tgt);
            System.out.println(para[maxIndex]);
        }
    }

    // 计算最匹配的句子的下标
    public static int parse(Set<String>[] sets, String tgt) {
        String[] words = tgt.split(" ");
        int max = 0;
        int index = 0;
        for (int i = 0; i<sets.length; i++) {
            Set<String> set = sets[i];
            // 防止重复单词计数
            Set<String> history = new HashSet<String>();
            int count = 0;
            for (String word : words) {
                if (history.contains(word)) continue;
                if (set.contains(word.toLowerCase().trim())) count++;
                history.add(word);
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }
        return index;
    }
}
