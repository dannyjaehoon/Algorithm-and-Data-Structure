package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // LIS
        // 1. dp O(n^2)
        // 2. binary search O(n log n)

        // I use a dp array where dp[i] represent the length of the longest increasing subsequence ending at index i
        // we initialize all values to 1 since every element is an LIS of length 1 by itself

        // dp
        // nums = [10, 9, 2, 5, 3, 7, 101, 18]
        // i = 1 (nums[1] = 9)
        // 10(nums[0]) > 9 -> skip
        // dp[1] remains 1

        // i = 2 (nums[2] = 2)
        // nums[0] = 10 → skip
        // nums[1] = 9 → skip
        // dp[2] remains 1

        // i = 3 (nums[3] = 5)
        // nums[0] = 10 → skip
        // nums[1] = 9 → skip
        // nums[2] = 2 → 2 < 5 → dp[3] = max(dp[3], dp[2]+1) = 2

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 최소 길이 = 1

        for(int i = 1; i<n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) maxLen = Math.max(maxLen, len);
        return maxLen;


    }
}
