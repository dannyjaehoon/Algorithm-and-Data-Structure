package medium;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        // kadane algorithm : if the current running sum becomes negative, its better to start a new subarray from the current element

        // curSum : the current running sum of the current subArray
        // maxSum : which tracks the maximum sum seen so far.

        // nums   : [-2, 1,-3,4,-1,2,1,-5,4]
        // curSum = Max(num, curNum + num);
        // maxSum = Max(maxSum, curSum);

        // step 1
        // curSum = -2 or -2 = -2
        // maxSum = 0 or -2 = 0

        // step 2
        // curSum = 1 or (-2 + 1 = -1) = 1
        // maxSum = 1 or 1 = 1

        // step 3
        // curSum = -3 or (1 - 3 = -2) = -2
        // maxSum = 1 or -2 = 1

        // step 4
        // curSum = 4 or (-2 + 4 = 2) = 4
        // maxSum = 1 or 4 = 4

        // step 5
        // curSum = -1 or (4 - 1) = 3
        // maxSum = 4 or 3 = 4

        // step 6
        // curSum = 2 or (3 + 2 = 5) = 5
        // maxSum = 4 or 5 = 5

        // step 6
        // curSum = 1 or (5 + 1 = 6) = 6
        // maxSum = 5 or 6 = 6

        // step 7
        // curSum = -5 or (6 - 5) = 1
        // maxSum = 6 or 1 = 6

        // step 8
        // curSum = 4 or (1 + 4 = 5) = 5
        // maxSum = 6 or 5 = 6


        int curSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i< nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum , curSum);
        }

        return maxSum;
    }
}
