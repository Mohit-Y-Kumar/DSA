class Solution {
    int dp[][];

    public int solve(int stones[], int idx, int target) {
        if (idx == stones.length || target == 0) {
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        //skip
        int skip = solve(stones, idx + 1, target);
        //take
        int take = 0;
        if (stones[idx] <= target) {
            take = stones[idx] + solve(stones, idx + 1, target - stones[idx]);
        }

        return dp[idx][target] = Math.max(skip, take);
    }

    public int lastStoneWeightII(int[] stones) {
        int S = 0;

        for (int s : stones) {
            S += s;
        }

        int target = S / 2;
        dp = new int[stones.length + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int subsum = solve(stones, 0, target);

        return (S - 2 * subsum);

    }
}