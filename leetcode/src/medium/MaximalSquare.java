package medium;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        // dp[i][j] represents the length of the largest square that ends at position (i,j);
        // if matrix[i][j] == '1' then dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1]));

        // time-complexity : O(m * n);
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i<= m; i++) {
            for(int j = 1; j<=n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(
                            dp[i-1][j], Math.min(
                                    dp[i][j-1],
                                    dp[i-1][j-1]
                            )) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);

                }
            }
        }
        return maxLen * maxLen;
    }
}
