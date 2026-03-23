class Solution {

    class Pair {
        long max;
        long min;

        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    Pair[][] dp; // class-level dp

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Pair[m][n]; // initialize dp

        // Base case
        dp[0][0] = new Pair(grid[0][0], grid[0][0]);

        // Fill first row
        for (int j = 1; j < n; j++) {
            long val = grid[0][j];
            long max = dp[0][j-1].max * val;
            long min = dp[0][j-1].min * val;
            dp[0][j] = new Pair(max, min);
        }

        // Fill first column
        for (int i = 1; i < m; i++) {
            long val = grid[i][0];
            long max = dp[i-1][0].max * val;
            long min = dp[i-1][0].min * val;
            dp[i][0] = new Pair(max, min);
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                           // upmax ->a,upmin->b,leftmax->c,leftmin->d
                long a = dp[i-1][j].max * val;
                long b = dp[i-1][j].min * val;
                long c = dp[i][j-1].max * val;
                long d = dp[i][j-1].min * val;

                long maxVal = Math.max(Math.max(a, b), Math.max(c, d));
                long minVal = Math.min(Math.min(a, b), Math.min(c, d));

                dp[i][j] = new Pair(maxVal, minVal);
            }
        }

        Pair res = dp[m-1][n-1];
        if (res.max < 0) return -1;
        return (int)(res.max % 1000000007);
    }
}