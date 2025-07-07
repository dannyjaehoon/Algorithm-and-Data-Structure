package medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // We're given an array height[] where each element represents the height of a vertical line on the x-axis.
        // We need to find the two lines that, together with the x-axis, can contain the most water.
        // The goal is to maximize the area between two lines.

        // 1. Initialize two pointers: one at the beginning (left = 0) and one at the end (right = height.length - 1).
        // 2. Calculate the area between the two lines at left and right.
        // 3. Store the maximum area found so far.
        // 4. Move the pointer that is pointing to the shorter line inward.
        // 5. This is because moving the taller line inward cannot help increase the area.
        // 6. Repeat until the two pointers meet.

        // Example: [1,8,6,2,5,4,8,3,7]
        // Two pointers
        // left = 0;
        // right = height.length - 1;

        // 7 * 7 = 49
        // maxArea = (right - left) * min(height[left], height[right])
        // If height[left] < height[right], move left++
        // Else, move right--

        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int left = 0;
        int right = height.length - 1;
        int maxAmountOfWater = 0;

        while (left < right) {
            maxAmountOfWater = Math.max(
                    maxAmountOfWater,
                    (right - left) * Math.min(height[left], height[right])
            );

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAmountOfWater;
    }
}
