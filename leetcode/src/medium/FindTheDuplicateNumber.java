package medium;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {

        // Binary Search approach
        // low = 1, high = nums.length - 1
        // Example: nums = [1, 3, 4, 2, 2]

        // while (low < high)
        //     mid = low + (high - low) / 2;
        //     count how many numbers <= mid
        //     if (count > mid) → duplicate is in [low, mid] → high = mid
        //     else → duplicate is in [mid+1, high] → low = mid + 1

        // Step 1:
        // low = 1, high = 4
        // mid = 2
        // count = 3
        // → count > mid → high = 2

        // Step 2:
        // low = 1, high = 2
        // mid = 1
        // count = 1
        // → count <= mid → low = 2

        // At this point, low == high == 2 → answer is 2

        // Time-complexity: O(n log n)
        // Space-complexity: O(1)

        // Interview Questions:
        // 1. How would your approach change if the input array could contain multiple duplicates?
        // 2. What changes would you make if you were allowed to modify the array?
        // 3. What if all elements are the same?

        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
