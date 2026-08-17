class Solution {
    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {

            for (int j = 0; j <= amount; j++) {
                //take
                int take = Integer.MAX_VALUE;
                if (coins[i - 1] <= j) {
                    int res = dp[i][j - coins[i - 1]];
                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }

                //skip
                int skip = dp[i - 1][j];
                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE
                ? -1
                : dp[coins.length][amount];

    }
}