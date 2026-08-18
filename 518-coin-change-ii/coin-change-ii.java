class Solution {
    int dp[];

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1];

        Arrays.fill(dp, 0);
        dp[0] = 1;
        

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                int skip = dp[j];
                if (coins[i - 1] <= j) {
                    int take =  dp[j - coins[i - 1]];
                    dp[j] = take + skip;
                }

                
            }
        }
        return dp[amount];

    }
}