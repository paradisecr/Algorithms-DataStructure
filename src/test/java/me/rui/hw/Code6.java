package me.rui.hw;

/**
 * Created by caorui on 2017/9/27.
 */
public class Code6 {
    public static void main(String[] args) {
        int numOfDays = 4;
        int[][] taskList = new int[][]{
                {6,7},
                {5,10}
//                {20,21},
//                {2,23}
        };
        int[][] taskList2 = new int[][]{
                {1,6},
                {1,2},
                {1,9},
                {1,10},
                {1,13}
        };
        int[][] taskList3 = new int[][] {
        };
        int[][] taskList4 = new int[][] {
                {1,9}
        };
        System.out.println(maxStipend(5,taskList2));
    }

    public static int maxStipend(int numOfDays, int[][] taskList) {

        return internal( taskList, taskList.length - 1);
    }

    private static int internal(int[][] taskList, int i) {
        if (i < 0) return 0;
        if (i == 0) return taskList[i][1];
        int sum1 = 0, sum2 = 0,sum3=0;
        sum1 = internal(taskList, i-2) + taskList[i][1];
        sum2 = internal(taskList, i-1) + taskList[i][0];
        sum3 = internal(taskList,i-1);
        return Integer.max(sum1, sum2);
    }

}
