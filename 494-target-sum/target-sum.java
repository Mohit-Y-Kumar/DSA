class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // sum(P) = (totalSum + target) / 2
        if (totalSum + target < 0 || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (totalSum + target) / 2;

        if (subsetTarget > totalSum) {
            return 0;
        }

        int n = nums.length;

        // dp[i][j] = number of ways to make sum j
        // using first i elements
        int[][] dp = new int[n + 1][subsetTarget + 1];

        // Base case:
        // There is exactly 1 way to make sum 0:
        // choose nothing.
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= subsetTarget; j++) {

                // Skip nums[i - 1]
                int skip = dp[i - 1][j];

                // Take nums[i - 1]
                int take = 0;

                if (nums[i - 1] <= j) {
                    take = dp[i - 1][j - nums[i - 1]];
                }

                dp[i][j] = skip + take;
            }
        }

        return dp[n][subsetTarget];
    }
}