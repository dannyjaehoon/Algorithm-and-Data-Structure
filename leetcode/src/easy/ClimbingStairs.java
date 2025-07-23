package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();

        return dfs(0,n,memo);
    }

    public int dfs(int sum,int n, Map<Integer, Integer> memo) {
        if(sum > n) return 0;
        if(sum == n) return 1;

        if(memo.containsKey(sum)) return memo.get(sum);

        int count = dfs(sum + 1, n,memo) + dfs(sum + 2, n,memo);
        memo.put(sum, count);
        return count;
    }

//    public int climbStairs(int n) {
//        if( n <= 2) return 2;
//
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for(int i = 3; i<=n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }
}
