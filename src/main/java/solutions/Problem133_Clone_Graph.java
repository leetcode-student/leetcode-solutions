package solutions;

import java.util.*;

public class Problem133_Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> copyMap = new HashMap<>();

        visit(node, copyMap);

        return copyMap.get(node);
    }

    private void visit(Node node, Map<Node, Node> copyMap) {
        //System.out.println(node);
        Node copy = new Node();
        copy.val = node.val;
        copy.neighbors = new ArrayList<>();

        copyMap.put(node, copy);

        for (Node neighbor : node.neighbors) {
            if (!copyMap.containsKey(neighbor)) {
                visit(neighbor, copyMap);
            }

            copy.neighbors.add(copyMap.get(neighbor));
        }
    }
}
