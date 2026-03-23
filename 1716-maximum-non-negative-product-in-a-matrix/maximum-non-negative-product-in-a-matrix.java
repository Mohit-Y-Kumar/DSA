class Solution {

    class Pair {
        long max;
        long min;

        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }
     Pair[][] dp;
    public Pair solve(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case
        if (i == m - 1 && j == n - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }
        if (dp[i][j] != null) return dp[i][j];
        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        // Down
        if (i + 1 < m) {
            Pair down = solve(i + 1, j, grid);

            long a = grid[i][j] * down.max;
            long b = grid[i][j] * down.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        // Right
        if (j + 1 < n) {
            Pair right = solve(i, j + 1, grid);

            long a = grid[i][j] * right.max;
            long b = grid[i][j] * right.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        dp[i][j]= new Pair(maxVal, minVal);
        return dp[i][j];
    }

    public int maxProductPath(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;
      dp = new Pair[m][n];

        Pair res = solve(0, 0, grid);
        // If max is negative, return -1 (common constraint in problem)
        if (res.max < 0) return -1;

        return (int)(res.max % 1000000007);
    }
}