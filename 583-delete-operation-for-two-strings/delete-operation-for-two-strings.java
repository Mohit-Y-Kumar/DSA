class Solution {
    

    int lcs(int i, int j, String word1, String word2, int n, int m, int dp[][]) {
        if (i == n || j == m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
           return dp[n][m] = 1 + lcs(i + 1, j + 1, word1, word2, n, m, dp);
        }

       return  dp[i][j] = Math.max(
                lcs(i, j + 1, word1, word2, n, m, dp), lcs(i + 1, j, word1, word2, n, m, dp));

    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+ 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (m + n - 2 * lcs(0, 0, word1, word2, n, m, dp));

    }
}