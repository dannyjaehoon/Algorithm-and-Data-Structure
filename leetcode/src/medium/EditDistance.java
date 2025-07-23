package medium;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        // example
        // word1 = "horse"
        // word2 = "ros"

        // dp[i][j] = the minimum number of operations required to convert the first i characters of word1 into first j characters of word2

        // m = word1.length
        // n = word2.length

        /*

               ""     r         o        s     = n

        ""     0      1         2        3

        h.     1      1         2        3

        o      2      2         1        2

        r      3      2         2        2

        s      4      3         3        2

        e      5      4         4        3 <- answer

        = m
        */

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // for the case word1 or word2 is empty
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        for(int j = 0; j <= n; j++) dp[0][j] = j;


        for(int i = 1; i <= m ;i++) {
            for(int j = 1; j<= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i-1][j],              // delete
                            Math.min(dp[i][j-1],     // insert
                                    dp[i-1][j-1]    // replace
                            )
                    );
                }
            }
        }
        return dp[m][n];

    }
}
