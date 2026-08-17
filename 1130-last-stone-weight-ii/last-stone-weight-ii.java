class Solution {
    int dp[];

    public int lastStoneWeightII(int[] stones) {
        int S = 0;

        for (int s : stones) {
            S += s;
        }

        int target = S / 2;
        dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];

            for (int j = target; j >= stone; j--) {

                int take = stone + dp[j - stone];
                int skip = dp[j];

                dp[j] = Math.max(skip, take);
            }
        }

        return (S - 2 * dp[target]);

    }
}