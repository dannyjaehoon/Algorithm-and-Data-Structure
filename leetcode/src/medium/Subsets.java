package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        // To generate all subsets, I use a recursive depth-first search

        // 1. initiate a recursive helper(DFS) to form the subset
        // 2. At each resursive call, add the current subset(path) to the result list
        // 3. use the start index so that each element is only considered once per path,
        //    preventing duplicates and ensuring combinations are generated in order

        // Time-complexity : O(n * 2^n); 2^n -> two to the power of n
        // Space-complexity : O(n * 2^n);

        // 1. Can you explain the time and space complexity of your solution, and why it is not O(n²)?
        // 2. Why did you choose a recursive backtracking approach? Could you solve this problem iteratively, and what would the trade-offs be?
        // 3. If the input array contains duplicate elements (e.g., [1,2,2]), how would you modify your solution to avoid duplicate subsets?

        dfs(new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<Integer> temp, int[] nums, int start) {

        res.add(new ArrayList<>(temp));

        for(int i = start; i<nums.length; i++) {
            temp.add(nums[i]);

            dfs(temp, nums, i+1);

            temp.remove(temp.size() - 1);
        }

    }
}
