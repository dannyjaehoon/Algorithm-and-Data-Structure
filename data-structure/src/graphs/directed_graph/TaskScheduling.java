package graphs.directed_graph;

import java.util.*;

public class TaskScheduling {
    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for(String task : tasks) {
            inDegree.put(task,0);
            graph.put(task, new ArrayList<>());
        }

        for(List<String> req : requirements) {
            String from = req.get(0);
            String to = req.get(1);

            graph.get(from).add(to);
            inDegree.put(to, inDegree.getOrDefault(to,0) + 1);
        }

        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()) {
            String task = q.poll();
            res.add(task);

            for(String next : graph.get(task)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0) q.offer(next);
            }
        }

        if(res.size() != tasks.size()) {
            throw new IllegalArgumentException("Cycle detected, invalid task requirements");
        }

        return res;
    }
}
