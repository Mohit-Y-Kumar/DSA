class Solution {
    int dp[][];

    public int solve(int i, int j, String text1, String text2, int n, int m) {

        if (i == n || j == m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + solve(i + 1, j + 1, text1, text2, n, m);
        } else {
            dp[i][j] = Math.max(
                    solve(i + 1, j, text1, text2, n, m),
                    solve(i, j + 1, text1, text2, n, m));
        }
        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, text1, text2, n, m);
    }
}