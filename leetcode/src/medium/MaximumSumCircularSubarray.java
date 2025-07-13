package medium;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {

        int total = nums[0];

        int curSum = nums[0];
        int maxSum = nums[0];

        int curMinSum = nums[0];
        int minSum = nums[0];

        // the total sum - min subarray sum = max sum array

        for(int i = 1; i <nums.length; i++) {

            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);

            curMinSum = Math.min(nums[i], curMinSum + nums[i]);
            minSum = Math.min(minSum, curMinSum);

            total += nums[i];
        }

        // Reason why we need this: if (maxSum < 0) return maxSum;
        // When all elements in the nums array are negative (e.g., [-3, -2, -3]),
        // total - minSum becomes 0, which represents an empty subarray (not allowed).
        // So we return maxSum, which is the least negative number (i.e., the maximum subarray sum).

        if(maxSum < 0) return maxSum;

        // answer could be one of the two cases :
        // Case 1. Non-circular subarray
        // Case 2. Circular subarray(wrap-around)
        // return the larger value between the two possible cases.

        return Math.max(maxSum, total - minSum);
    }
}
