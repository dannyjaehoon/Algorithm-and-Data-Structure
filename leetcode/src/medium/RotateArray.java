package medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        // 1. Use a queue: poll the first element and add it to the back, repeating this process k times.
        // 2. Use nested loops: in each iteration, remove the first element and shift the rest to the left, then append the removed element to the end.

        // Reverse-based in-place rotation

        // 1. reverse all -> [7,6,5,4,3,2,1]
        // 2. reverse from 0 to k-1 -> [5,6,7,4,3,2,1]
        // 3. reverse the rest -> [5,6,7,1,2,3,4]

        int n = nums.length;
        k %= n; // Without this, rotating more than n times would waste time and possibly give incorrect results.

        // time-complexity - O(n)
        // space-complexity - O(1)

        // 3 Questions:
        // 1. Can you improve your solution to use O(1) extra space?
        // 2. How would you modify your solution to rotate a linked list instead of an array?
        // 3. How would your approach change if you were allowed to use additional memory?

        if (n == 1) return;
        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
