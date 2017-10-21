package me.rui.ab;

/**
 * Created by caorui on 2017/9/28.
 */
public class Code2 {
    public static void main(String[] args) {
        int aa = 4, bb = 5;

    }

    public static int minMoves(int[][] maze, int x, int y) {
        // 1. find all shortest path
        int[][] d = new int[maze.length][maze[0].length];
        for (int i=0; i<d.length; i++) {
            for (int j=0; j<d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        return -1;
    }


    class LinkNode {
        Object val;
        LinkNode next;
    }

    public LinkNode  findMidNode(LinkNode head){
        LinkNode p1,p2;
        p1 = p2 = head;
        while(p2.next!=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
