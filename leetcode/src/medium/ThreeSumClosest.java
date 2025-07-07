package medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        /*
        Problem: 3Sum Closest
        Given an integer array `nums` of length n and an integer target,
        return the sum of three integers in nums such that the sum is closest to the target.

        Approach:
        - Sort the array to enable the two-pointer approach.
        - For each element (fixed as the first number of the triplet), use two pointers (left, right)
          to scan the rest of the array and find the closest sum.
        - Keep track of the closest sum found so far.

        Time Complexity:
        - Sorting: O(n log n)
        - Two-pointer loop: O(n^2)
        => Overall: **O(n^2)** time complexity

        Space Complexity:
        - O(1), as we use only a few variables (in-place sorting if allowed)

        Sample Interview Questions a candidate might be asked:
        1. Why do we need to sort the array first?
        2. What edge cases should we consider (e.g., duplicates, small array)?
        3. How would you optimize this further if performance was critical?

        */
        int n = nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // Exact match
                }
            }
        }

        return closestSum;
    }
}
