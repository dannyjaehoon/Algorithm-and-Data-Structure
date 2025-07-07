package medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int numOfRed = 0;   // Count of 0's
        int numOfWhite = 0; // Count of 1's
        int numOfBlue = 0;  // Count of 2's

        // Count occurrences
        for (int num : nums) {
            if (num == 0) numOfRed++;
            else if (num == 1) numOfWhite++;
            else numOfBlue++;
        }

        // Overwrite nums array with sorted values
        int totalLength = numOfRed + numOfWhite + numOfBlue;
        for (int i = 0; i < totalLength; i++) {
            if (numOfRed > 0) {
                nums[i] = 0;
                numOfRed--;
            } else if (numOfWhite > 0) {
                nums[i] = 1;
                numOfWhite--;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void sortColorsV1(int[] nums) {

        // use Dutch National Flag algorithm
        // 0 for low, 1 for mid, 2 for high

        // nums[mid] == 0:
        // swap nums[low] and nums[mid]
        // low++, mid++

        // nums[mid] == 1:
        // mid++

        // nums[mid] == 2:
        // swap nums[mid] and nums[high]
        // high--

        // Example: [2,0,2,1,1,0]
        // Step-by-step:

        // start
        // low=0, mid=0, high=5
        // [2,0,2,1,1,0]

        // 1. nums[mid]=2 -> swap(mid, high)
        // [0,0,2,1,1,2] low=0, mid=0, high=4

        // 2. nums[mid]=0 -> swap(low, mid)
        // [0,0,2,1,1,2] low=1, mid=1, high=4

        // 3. nums[mid]=0 -> swap(low, mid)
        // [0,0,2,1,1,2] low=2, mid=2, high=4

        // 4. nums[mid]=2 -> swap(mid, high)
        // [0,0,1,1,2,2] low=2, mid=2, high=3

        // 5. nums[mid]=1 -> mid++
        // 6. nums[mid]=1 -> mid++

        // Second example: [2,0,1]
        // start
        // low=0, mid=0, high=2
        // [2,0,1]

        // 1. nums[mid]=2 -> swap(mid, high)
        // [1,0,2] low=0, mid=0, high=1

        // 2. nums[mid]=1 -> mid++
        // 3. nums[mid]=0 -> swap(low, mid)
        // [0,1,2]

        // time complexity: O(n)
        // space complexity: O(1)

        // Interview questions:
        // 1. Can you explain why we use mid <= high instead of mid < high?
        // 2. Can you think of a way to solve this problem with only one pass instead of two?
        // 3. Have you heard of the Dutch National Flag algorithm? Can you describe it?

        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // We need to use mid <= high because we need to check the element at the high index as well.
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(mid, high, nums);
                high--;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
