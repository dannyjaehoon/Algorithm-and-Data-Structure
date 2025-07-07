package medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Input: [1,2][2,3][3,4][1,3]

        // Step-by-step plan:
        // 1. Sort the array by the ending element.
        //    The earlier an interval ends, the more room we have to include additional intervals.
        //    After sorting: [1,2][2,3][1,3][3,4]

        // 2. Initialize lastInterval to the first interval after sorting.

        // 3. Traverse from the second interval:
        //    - If current interval starts before lastInterval ends -> count++
        //    - Else, update lastInterval to current


        // step 1.
        // [1,2][2,3]
        // lastInterval = [2,3]



        // step 2.
        // [2,3][1,3]
        // if(3 > 1) count++;
        // lastInterval = [2,3]

        // step 3.
        // [2,3][3,4]
        // lastInterval = [3,4]

        // Time-complexity: O(n log n) due to sorting
        // Space-complexity: O(1)

        // Interview questions:
        // 1. Why does sorting by end time guarantee the optimal solution?
        // 2. What if the intervals can have negative start or end values?
        // 3. How would you modify the solution to return the actual list of non-overlapping intervals instead of just the count?

        int n = intervals.length;
        if (n == 1) return 0;

        int count = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] lastInterval = intervals[0];

        for (int i = 1; i < n; i++) {
            int[] curInterval = intervals[i];
            if (lastInterval[1] > curInterval[0]) {
                count++;
                continue;
            }
            lastInterval = curInterval;
        }

        return count;
    }
}
