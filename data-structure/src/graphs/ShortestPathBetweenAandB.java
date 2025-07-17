package graphs;

import java.util.*;

public class ShortestPathBetweenAandB {
//    Input:
//
//    graph = [[1, 2], [0, 2, 3], [0, 1], [1]]
//    A = 0
//    B = 3
    // time-complexity : O(n + m)
    // n : the number of nodes in the graph
    // m : the number of edges
    // we would traverse every node anf edge exactly once.

    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        Queue<Integer> q = new LinkedList<>();

        Set<Integer>visited = new HashSet<>();

        q.add(a);
        visited.add(a);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int u = q.poll();
                if(b == u) return level;

                for(int v : graph.get(u)) {
                    if(!visited.contains(v)) {
                        q.add(v);
                        visited.add(v);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
