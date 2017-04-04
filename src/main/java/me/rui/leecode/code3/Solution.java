package me.rui.leecode.code3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cr on 2017/3/25.
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] list = s.toCharArray();
        int length = 1;
        if(list.length == 0) return 0;
        int i=0, j=0;
        Set<Character> cache = new HashSet();
        cache.add(list[i]);
        while(j < list.length) {
            if(i == j) {
                j++;
                continue;
            }
            if(cache.contains(list[j])) {
                i = j;
                cache.clear();
                cache.add(list[j]);
                break;
            }
            if(j-i+1 > length) length = j-i+1;
            if(list[j] == list[j-1]){
                i = j;
                cache.clear();
                cache.add(list[j]);
                break;
            }
            j++;
        }
        return length;
    }
}