package moe.tawawa.leetcode.q133_Clone_Graph;

import model.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author GeeKaven
 * @date 2021/3/9 22:34
 */
public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }
        return clone;
    }

    public Node cloneGraphBfs(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> marked = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clone = new Node(node.val);
        marked.put(node, clone);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (!marked.containsKey(neighbor)) {
                    marked.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                marked.get(temp).neighbors.add(marked.get(neighbor));
            }
        }
        return clone;
    }
}
