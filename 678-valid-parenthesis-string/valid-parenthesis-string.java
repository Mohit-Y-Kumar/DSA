class Solution {
    boolean solve(int i, int opn, String s, int n, Boolean[][] dp) {
        if (i == n)
            return opn == 0;

        // Directly return cached boolean value
        if (dp[i][opn] != null)
            return dp[i][opn];

        boolean isValid = false;

        if (s.charAt(i) == '*') {
            isValid |= solve(i + 1, opn + 1, s, n, dp);
            isValid |= solve(i + 1, opn, s, n, dp);
            if (opn > 0) {
                isValid |= solve(i + 1, opn - 1, s, n, dp);
            }
        } else if (s.charAt(i) == '(') {
            isValid = solve(i + 1, opn + 1, s, n, dp);
        } else if (s.charAt(i) == ')') {
            if (opn > 0) {
                isValid = solve(i + 1, opn - 1, s, n, dp);
            }
        }

        // Store and return boolean directly
        return dp[i][opn] = isValid;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n + 1]; // defaults to null
        return solve(0, 0, s, n, dp);
    }
}