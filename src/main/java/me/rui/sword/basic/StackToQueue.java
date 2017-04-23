package me.rui.sword.basic;

import java.util.Stack;

/**
 * Created by cr on 2017/4/20.
 * 用两个栈来实现一个队列
 *
 * 题目描述:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：
 * 要点在于对两个栈的控制，将栈2作为queue,栈1作为一个数据缓存。
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception{
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) throw new Exception("queue is empty");
        return stack2.pop();
    }
}
