class Solution {
    int dp[];

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;

            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(
                        dp[j],
                        1 + dp[j - square]);
            }
        }

        return dp[n];
    }
}