package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // First, I insert all the numbers from the input array into a HashSet.
        // This allows for constant-time lookups.

        // Then, I iterate through each number in the set.
        // For each number, I check if it is the start of a sequence
        // by seeing if num - 1 is not in the set.

        // If it is the start of a sequence, I use a while loop to count
        // how long the sequence is by checking if num + 1, num + 2, and so on are in the set.

        // I keep track of the maximum length among all such sequences.

        // This approach ensures that each number is visited only once throughout the whole process,
        // so the overall time complexity is O(N).

        // Interview Questions:
        // 1. Why do you check for num - 1 instead of num + 1 in the loop?
        // 2. What is the time and space complexity of your solution, and why?
        // 3. How would your solution handle duplicate numbers in the input?

        int maxLength = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {

            // This condition checks whether the current number num is
            // the starting point of a consecutive sequence.
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}

