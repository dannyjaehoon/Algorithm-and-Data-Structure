package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        // To solve this, we iterate through the existing intervals and :
        // 1. Add all intervals that end before the new Interval starts
        // 2. merge all overlapping intervals with new interval
        //    - to do this, update the start to the minimum of both starts,
        //      and the end to the maximum of both ends.
        // 3. add the merged interval
        // 4. finally, add the remaining intervals that start after the newInterval ends

        // for example
        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
        // newInterval = [4,8]
        // the newInterval overlaps with [3,5],[6,7],[8,10]
        // so we merge them into [3,10]
        // result : [[1,2],[3,10],[12,16]]

        // time complexity - n + n = 2n = O(n)
        // space complexity - O(n) due to List<int[]> res

        // 🧠 Interview Questions:
        // 1. Why is brute-force not an efficient approach for this problem?
        // 2. Can you describe the technique you used to solve this problem and why it’s efficient?
        // 3. What other methods might exist to solve this problem, and how do they compare?
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals that end before the new Interval starts
        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals with the new interval
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 3. Add the merged interval
        res.add(newInterval);

        // 4. Add the remaining intervals
        while(i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
