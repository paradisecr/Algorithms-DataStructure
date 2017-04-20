package me.rui.sword.basic;

/**
 * Created by cr on 2017/4/20.
 *  替换空格
 *  题目描述:请实现一个函数，将一个字符串中的空格替换成“%20”。
 *  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 *  思路：1. 计算新字符串的长度；
 *        2. 从后往前扫描字符串，填充到新串中
 */
public class ReplaceSpace {
    public String replaceSpace(String str) {
        //1. 计算新字符串的长度；
        //2. 从后往前扫描字符串，填充到新串中
        int srcLength = str.length();
        int dstLength = srcLength;
        int i,j;
        for (i = 0; i< srcLength; i++) {
            if (' ' == str.charAt(i)) dstLength += 2;
        }
        StringBuffer buffer = new StringBuffer(dstLength);
        buffer.setLength(dstLength);               // important !!!
        j = dstLength - 1;
        for (i = srcLength - 1; i>=0; i--) {
            if (' ' != str.charAt(i)) {
                buffer.setCharAt(j--, str.charAt(i));
            } else {
                buffer.setCharAt(j--, '0');
                buffer.setCharAt(j--, '2');
                buffer.setCharAt(j--, '%');
            }
        }
        return buffer.toString();
    }
}
