package me.rui.sword.greatidea;

import java.util.Stack;

/**
 * Created by cr on 2017/4/22.
 *
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 思路：
 *
 */
public class IsPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> dataStack = new Stack<>();
        if (pushA == null || pushA.length == 0) {
            if ((popA == null || popA.length == 0)) return true;
            return false;
        }
        if (null == popA || popA.length != pushA.length ) return false;
        int i = 0;
        for (int popData : popA) {
            if (!dataStack.isEmpty() && dataStack.peek() == popData) {
                dataStack.pop();
                continue;
            }
            while (i < pushA.length) {
                dataStack.push(pushA[i++]);
                if (dataStack.peek() == popData)  break;
            }
            if (dataStack.isEmpty() || dataStack.peek() != popData) return false;
            dataStack.pop();
        }
        return true;
    }
}
