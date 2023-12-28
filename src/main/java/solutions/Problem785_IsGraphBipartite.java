package solutions;

import java.util.*;

public class Problem785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> bfsQueue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i)) {
                bfsQueue.add(i);
                visited.add(i);
                a.add(i);
            }

            while (!bfsQueue.isEmpty()) {
                int node = bfsQueue.poll();

                //System.out.println("a=" + a + ", b=" + b);

                int[] neighbors = graph[node];
                for (int neighbor : neighbors) {
                    if (a.contains(node) && a.contains(neighbor)) {
                        return false;
                    } else if (b.contains(node) && b.contains(neighbor)) {
                        return false;
                    }

                    if (!visited.contains(neighbor)) {
                        bfsQueue.add(neighbor);
                        visited.add(neighbor);
                        if (a.contains(node)) {
                            b.add(neighbor);
                        } else {
                            a.add(neighbor);
                        }
                    }
                }
            }
        }

        return true;
    }
}
