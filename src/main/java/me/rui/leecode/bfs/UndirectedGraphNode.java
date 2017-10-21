package me.rui.leecode.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caorui on 2017/9/10.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
