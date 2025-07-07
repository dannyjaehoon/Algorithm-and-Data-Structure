package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {



        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            // Combination Sum
            // Return a list of all unique combinations of candidates where the chosen numbers sum to target
            // [2,2,3] is valid, but [3,2,2] is considered the same combination.

            // DFS technique
            // dfs(candidates, target, 0 (sum), 0 (start index), temp list)
            // Return the final result list

            // Time complexity: O(2^target) in the worst case (exploring all combinations up to the target)
            // Space complexity: O(target) due to the recursion stack and path list

            // Interview Questions:
            // 1. What’s the difference between backtracking and DFS?
            // 2. Could you transform this problem into a bottom-up dynamic programming solution?
            // 3. How would the problem change if the order of the elements in the combinations matters?
            //    - For example, how would you handle it if [2,3] and [3,2] were considered different combinations?

            dfs(candidates, target, 0, 0, new ArrayList<>());
            return res;
        }

        public void dfs(int[] candidates, int target, int sum, int start, List<Integer> temp) {
            if (sum > target) return;

            if (sum == target) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);                    // 현재 숫자 선택
                dfs(candidates, target, sum + candidates[i], i, temp); // 같은 숫자를 다시 사용할 수 있음
                temp.remove(temp.size() - 1);               // 백트래킹
            }
        }
}
