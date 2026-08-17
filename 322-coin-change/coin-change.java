class Solution {
    int[][] dp;

    public int solve(int[] coins, int idx, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idx == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= amount) {
            int result = solve(coins, idx, amount - coins[idx]);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        int skip = solve(coins, idx + 1, amount);
        dp[idx][amount] = Math.min(take, skip);
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length+1][amount+1];
       for(int[]arr:dp){
        Arrays.fill(arr,-1);
       }
        int ans = solve(coins, 0, amount);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}