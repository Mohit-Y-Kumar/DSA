class Solution {

    public int solve(int[] nums, int idx, int target) {

        // Base case
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Skip
        int skip = solve(nums, idx + 1, target);

        // Take
        int take = 0;
        if (nums[idx] <= target) {
            take = solve(nums, idx + 1, target - nums[idx]);
        }

        return take + skip;
    }

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

        return solve(nums, 0, subsetTarget);
    }
}