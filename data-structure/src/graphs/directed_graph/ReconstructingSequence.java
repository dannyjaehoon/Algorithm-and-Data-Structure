package graphs.directed_graph;

import java.util.*;

public class ReconstructingSequence {

    public static boolean sequenceReconstruction(int[] original, List<List<Integer>> seqs) {
        // time-complexity = O(n + m) n-> original m -> seqs
        if(original.length == 0 || original == null)return false;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(List<Integer> seq : seqs) {
            for(int num : seq) {
                graph.putIfAbsent(num, new ArrayList<>());
                indegree.putIfAbsent(num, 0);
            }
        }

        if(graph.size() != original.length) return false;

        for(List<Integer> seq : seqs) {
            for(int i = 0; i<seq.size()-1; i++) {
                  int from = seq.get(i);
                  int to = seq.get(i+1);
                  graph.get(from).add(to);
                  indegree.put(to, indegree.get(to) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int node : indegree.keySet()) {
            if(indegree.get(node) == 0) {
                queue.add(node);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()) {
            if(queue.size() > 1) return false;

            int cur = queue.poll();

            if(original[idx] != cur) return false;
            idx++;

            for(int next : graph.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return idx == original.length;
    }

    public static void main(String[] args) {

    }
}
