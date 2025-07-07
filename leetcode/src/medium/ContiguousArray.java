package medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        // Return: the maximum length of a contiguous subarray with an equal number of 0 and 1

        // Example:
        // nums       = 0 1 1 1 1 1 0 0 0
        // converted  = -1 1 1 1 1 1 -1 -1 -1
        // prefixSum  = -1 0 1 2 3 4 3 2 1
        // index      =  0 1 2 3 4 5 6 7 8

        // We have:
        // - prefixSum 4 at index 5 and 6 → length = 6 - 4 = 2
        // - prefixSum 3 at index 4 and 6 → length = 6 - 4 = 2
        // - prefixSum 2 at index 3 and 7 → length = 7 - 3 = 4
        // - prefixSum 1 at index 2 and 8 → length = 8 - 2 = 6

        // So the maximum length is 6

        // Time-complexity: O(n)
        // Space-complexity: O(n)

        // Key Interview Questions:
        // 1. Why do you use map.put(0, -1) at the beginning?
        // 2. Can you explain why this solution works using prefix sum? Why do we turn 0s into -1s?
        // 3. How would your solution change if the array contained more than just 0s and 1s?

        int n = nums.length;
        int maxLength = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // When the prefixSum becomes 0 at a certain index, it means that the number of 0s and 1s are equal from index 0 to that index.
        // To correctly compute the length of this valid subarray, we assume that a cumulative sum of 0 existed at index -1.
        // Without this, we wouldn't be able to detect subarrays starting from index 0.

        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
