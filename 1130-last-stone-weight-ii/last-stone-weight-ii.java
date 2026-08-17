class Solution {
    int dp[][];

    public int lastStoneWeightII(int[] stones) {
        int S = 0;

        for (int s : stones) {
            S += s;
        }

        int target = S / 2;
        dp = new int[stones.length + 1][target + 1];
       
    
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 0; j <= target; j++) {

                int take = 0;

                if (stones[i - 1] <= j) {
                    take = stones[i - 1] + dp[i - 1][j - stones[i - 1]];
                }

                int skip = dp[i - 1][j];

                dp[i][j] = Math.max(skip, take);
            }
        }

        return (S - 2 * dp[stones.length][target]);

    }
}