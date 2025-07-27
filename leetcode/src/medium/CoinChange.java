package medium;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // coins = [1, 2, 5], amount = 11
        // dp[0] = 0
        // dp[1...11] = amount+1

        // time-complexity : O(amount * coins.length)

        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 1; i<=amount; i++) {
            for(int coin :coins) {
                if(i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
