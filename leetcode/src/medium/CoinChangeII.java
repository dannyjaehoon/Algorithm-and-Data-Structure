package medium;

public class CoinChangeII {
    public int change(int amount, int[] coins) {

        // For example : coins = [1, 2, 5], amount = 5
        // coin = 1:

        // dp[1] += dp[0] → 1

        // dp[2] += dp[1] → 1

        // dp[3] += dp[2] → 1

        // dp[4] += dp[3] → 1

        // dp[5] += dp[4] → 1
        // → dp = [1,1,1,1,1,1]

        // coin = 2:

        // dp[2] += dp[0] → 2

        // dp[3] += dp[1] → 2

        // dp[4] += dp[2] → 3

        // dp[5] += dp[3] → 3
        // → dp = [1,1,2,2,3,3]

        // coin = 5:

        // dp[5] += dp[0] → 4
        // → dp = [1,1,2,2,3,4]

        // Answer : dp[5] = 4
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
