class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        // dp[i][opn] represents whether s[i...n-1] is valid given 'opn' open brackets
        boolean[][] dp = new boolean[n + 1][n + 1];

        // Base case: at the end of the string (i = n), 
        // it is valid ONLY if the open count is exactly 0
        dp[n][0] = true;

        // Iterate backwards from the last character to the first
        for (int i = n - 1; i >= 0; i--) {
            for (int opn = 0; opn <= n; opn++) {
                boolean isValid = false;

                if (s.charAt(i) == '*') {
                    if (opn + 1 <= n) isValid |= dp[i + 1][opn + 1]; // treat '*' as '('
                    isValid |= dp[i + 1][opn];                        // treat '*' as empty string
                    if (opn > 0) isValid |= dp[i + 1][opn - 1];       // treat '*' as ')'
                } else if (s.charAt(i) == '(') {
                    if (opn + 1 <= n) isValid = dp[i + 1][opn + 1];
                } else if (s.charAt(i) == ')') {
                    if (opn > 0) isValid = dp[i + 1][opn - 1];
                }

                dp[i][opn] = isValid;
            }
        }

        // The answer starts at index 0 with 0 open brackets
        return dp[0][0];
    }
}