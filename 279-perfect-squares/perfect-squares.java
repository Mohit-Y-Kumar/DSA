class Solution {
    int dp[];

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, n + 1);

        
            dp[0] = 0;
        

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

               dp[j]= dp[j];

                // Take i^2 if possible
                if (i * i <= j) {
                    dp[j] = Math.min(
                            dp[j],
                            1 + dp[j - i * i]);
                }
            }
        }
        return dp[n];
    }
}