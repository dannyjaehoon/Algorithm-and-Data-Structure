package medium;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // example
        // 1 2 3 4
        // (2*3*4) (1*3*4) (1*2*4) (1*2*3)

        // Prefix product:
        // 1 1 2 6
        // initiate ans[0] = 1
        // iterate with a for loop from 1 to n-1
        // ans[i] = ans[i-1] * nums[i-1];

        // Suffix product:
        // 24 12 4 1
        // initiate rightPointer = 1
        // iterate with a for loop from n-1 to 0
        // ans[i] = ans[i] * rightPointer;
        // rightPointer *= nums[i];

        // return ans;

        // Time complexity: O(n)
        // Space complexity: O(1)
        // Since the `ans` array is considered the output array, we typically exclude it when calculating the additional (auxiliary) space complexity.

        // Interview questions:
        // 1. What is the prefix/suffix product in this context?
        // 2. What does "the product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer" mean?
        // 3. Is there another solution for this problem?

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int rightPointer = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rightPointer;
            rightPointer *= nums[i];
        }

        return ans;
    }
}
