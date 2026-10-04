class Solution {
    boolean solve(int i, int opn, String s, int n,int dp[][]) {
        if (i == n) return opn == 0;

        if(dp[i][opn] != -1){
            return dp[i][opn]==1;
        }

        boolean isValid = false;

        if (s.charAt(i) == '*') {
            isValid |= solve(i + 1, opn + 1, s, n,dp); //treat open
            isValid |= solve(i + 1, opn, s, n,dp); //treat empty
            if (opn > 0) {
                isValid |= solve(i + 1, opn - 1, s, n,dp); //treat close

            }

        } else if (s.charAt(i) == '(') { //open
            isValid = solve(i + 1, opn + 1, s, n,dp);
        }

        else if (opn > 0) {
            isValid |= solve(i + 1, opn - 1, s, n,dp); // close

        }
       dp[i][opn] = isValid ? 1 : 0;
        return isValid;
    }

    public boolean checkValidString(String s) {
        int idx = 0;
        int open = 0;
        int n = s.length();
        int dp[][] = new int[n][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(idx, open, s, n, dp);

    }
}