package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {


        dfs(new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<Integer> temp, int[] nums, int start) {
        if(temp.size() > nums.length) {
            return;
        }

        res.add(new ArrayList<>(temp));

        for(int i = start; i<nums.length; i++) {
            temp.add(nums[i]);

            dfs(temp, nums, i+1);

            temp.remove(temp.size() - 1);
        }

    }
}
