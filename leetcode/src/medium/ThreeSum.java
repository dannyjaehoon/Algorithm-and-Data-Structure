package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // To solve this question:
        //
        // - Sorting the Array:
        //   - You start by sorting the input array (Arrays.sort(nums)).
        //   - Sorting helps to handle duplicates easily and allows for the two-pointer technique.
        //
        // - Iterating with a For Loop:
        //   - You loop from i = 0 to nums.length - 2 because we need at least three numbers.
        //   - To avoid duplicate triplets, you skip any nums[i] that is the same as the previous one (if (i > 0 && nums[i] == nums[i - 1]) continue;).
        //
        // - Two Pointers:
        //   - You initialize left = i + 1 and right = nums.length - 1.
        //   - While left < right, you check the sum of the three numbers:
        //     - If the sum equals zero, you add the triplet to the result list.
        //     - Then, you move left and right pointers while skipping duplicates using the nested while loops.
        //     - If the sum is less than zero, you increment left to get a larger number.
        //     - If the sum is greater than zero, you decrement right to get a smaller number.
        //
        // - Returning the Result:
        //   - After iterating, you return the res list containing all unique triplets.

        // time complexity - n * n-1 == O(n^2)
        // space complexity - O(n) = List<List<Integer>> res

        // 3 Questions to ask an interviewee
        // 1. Can you describe the technique you used to solve this problem and why it’s efficient?
        // 2. is there more efficient way to solve this problem?
        // 3. What technique can you use if the array can not be sorted?
        Arrays.sort(nums);  // Sort the array to apply the two-pointer approach
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum > 0) {
                    right--;  // Sum too large, need a smaller number
                } else {
                    left++;   // Sum too small, need a larger number
                }
            }
        }

        return res;
    }
}
