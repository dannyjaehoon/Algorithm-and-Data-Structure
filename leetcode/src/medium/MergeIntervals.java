package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Merge all overlapping intervals and return an array of non-overlapping intervals.
        // For example:
        // Input: [[1,3],[2,6],[8,10],[15,18]]
        // - [1,3] and [2,6] overlap => merge them into [1,6]
        // - Final result: [[1,6],[8,10],[15,18]]
        //
        // Steps:
        // 1️⃣ Sort intervals by their start times.
        // 2️⃣ Initialize a result list and add the first interval.
        // 3️⃣ Iterate through each interval from the second one:
        //    - If the current interval overlaps with the last one in the result list,
        //      create a new merged interval and replace the last one in the result list.
        //    - Otherwise, add the current interval to the result list.
        // 4️⃣ Return the result as a 2D array.
        //
        // Time complexity: O(n log n) (due to sorting)
        // Space complexity: O(n) (result list)

        // 3 Interview Questions to Ask:
        // 1. Why do you check the condition (last[0] <= current[0] && current[0] <= last[1]) instead of just (current[0] <= last[1])?
        // 2. Why are we removing the last interval and adding a merged one instead of just updating the last one in-place?
        // 3. What would happen if the input was already sorted or only had one interval?

        int n = intervals.length;
        int m = intervals[0].length;
        if(n == 1) return intervals;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        res.add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int[] cur = res.get(res.size()-1);
            if(cur[0] <= intervals[i][0] && intervals[i][0] <= cur[1]) {
                int[] ans = new int[2];
                ans[0] = Math.min(cur[0], intervals[i][0]);
                ans[1] = Math.max(cur[1], intervals[i][1]);
                res.remove(res.size()-1);
                res.add(ans);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
