package graphs.directed_graph;

import java.util.*;

public class TaskScheduling2 {
    public int minimumTime(String[] tasks, int[] times, List<List<String>> requirements) {
        int n = tasks.length;
        Map<String, Integer> taskIndex = new HashMap<>();

        for(int i = 0; i < n; i++) {
            taskIndex.put(tasks[i], i);
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(List<String> req : requirements) {
            int u = taskIndex.get(req.get(0));
            int v = taskIndex.get(req.get(1));

            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for(int i = 0; i < n ; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                startTime[i] = 0;
                endTime[i] = times[i];
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                startTime[next] = Math.max(startTime[next], endTime[cur]);
                indegree[next]--;
                if(indegree[next] == 0) {
                    endTime[next] = startTime[next] + times[next];
                    queue.add(next);
                }
            }
        }
        int result = 0;
        for(int f : endTime) result = Math.max(result,f);

        return result;
    }
}
