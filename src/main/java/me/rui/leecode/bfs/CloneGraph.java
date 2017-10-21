package me.rui.leecode.bfs;

import java.util.*;

/**
 * Created by caorui on 2017/9/10.
 */
public class CloneGraph {


    public UndirectedGraphNode dfsCloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        UndirectedGraphNode clone = dfsClone(node, visited);
        return clone;
    }

    private UndirectedGraphNode dfsClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
        if (node == null) return null;
        if (visited.containsKey(node.label)) return visited.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfsClone(neighbor, visited));
        }
        return clone;
    }

    public UndirectedGraphNode bfsCloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode root = null;
        if (node == null) return root;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                // neighbor还没有被遍历过，加入队列
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                // neighbor是双向的 这里加单向联系
                map.get(curNode.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return root;
    }


}
