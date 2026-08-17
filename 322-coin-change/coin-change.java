class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        
        for (int i = 1; i <= coins.length; i++) {

            for (int j = 0; j <= amount; j++) {
                //take
                int take = Integer.MAX_VALUE;
                if (coins[i - 1] <= j) {
                    int res = dp[j - coins[i - 1]];
                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }

                //skip
                int skip = dp[j ];
                dp[j] = Math.min(take, skip);
            }
        }

        return dp[amount] == Integer.MAX_VALUE
                ? -1
                : dp[amount];

    }
}