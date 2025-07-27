package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(), nums, used);
        return res;
    }

    public void dfs(List<Integer> temp, int[] nums, boolean[] used ) {

        if(nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            dfs(temp,nums, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
