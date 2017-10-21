package me.rui.leecode.subarray;

/**
 * Created by caorui on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(lastRemaining_Solution(15,21));
    }
    public static  int lastRemaining_Solution(int n, int m) {
        if(n==0) return -1;

        int s=0;
        for(int i=2;i<=n;i++){
            s=(s+m)%i;
        }
        return s;
    }

}