package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // since nums[i] can be a negative value, we can not use the sliding window

        // Use prefix sum to store the sum up to the current index.
        // Use a HashMap to record how many times a prefix sum has appeared.
        // If currentSum - k has been seen before, it means there's a subarray that sums to k.

        // HashMap + Prefix Sum
        // nums = [1, 2, 3, -2, 1, 2, -1, 2]
        // k = 3

        // prefix[i] - prefix[j] == k
        // prefix[i] - k
        // default -> map = [[0,1]]

        // sum = 1
        // sum - k = -2
        // count = 0;
        // [[1,1]]

        // sum = 3
        // sum - k = 0
        // count = 1;
        // [[1,1], [3,1]]

        // sum = 6
        // sum - k = 3
        // count = 2;
        // [[1,1], [3,1], [6,1]]

        // sum = 4
        // sum - k = 1
        // count = 3;
        // [[1,1], [3,1], [4,1],[6,1]]

        // sum = 5
        // sum - k = 2
        // count = 3;
        // [[1,1], [3,1], [4,1],[5,1],[6,1]]

        // sum = 7
        // sum - k = 5
        // count = 4;
        // [[1,1], [3,1], [4,1],[5,1],[6,1],[7,1]]

        // sum = 6
        // sum - k = 3
        // count = 5;
        // [[1,1], [3,1], [4,1],[5,1],[6,2],[7,1]]

        // sum = 8
        // sum - k = 5
        // count = 6;
        // [[1,1], [3,1], [4,1],[5,1],[6,2],[7,1],[8,1]]

        // What does count += map.get(sum - k) mean?
        // Because sum - k may have appeared multiple times before.
        // So, for every time it occurred, there’s a valid subarray ending at the current index.
        // if nums = [1, 2, 1, 2], k = 3
        // [1,2] [2,1] [1,2] -> 3 times

        // time-complexity - O(n)
        // space-complexity - O(n)

        // 1. Why do we initialize the map with {0:1} at the beginning?
        // 2. Can this algorithm handle negative numbers in the array?
        // 3. What's the time and space complexity, and can it be optimized further?

        // key : prefixSum, value: count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
