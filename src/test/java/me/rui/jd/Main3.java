package me.rui.jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by caorui on 2017/9/8.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String[] strs = scanner.nextLine().split("");
        if (strs.length <=1) {
            System.out.println(0);
            return;
        }
        int count = 1;
        for(int i = 0;i< strs.length; i++){
            if(strs[i].equals("(")){
                stack.push(strs[i]);
            }else if(strs[i].equals(")") && !stack.empty()){
                count *= stack.size();
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
