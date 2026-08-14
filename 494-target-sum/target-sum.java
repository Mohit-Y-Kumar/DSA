class Solution {
    public int solve(int[]nums,int idx,int currsum,int target){
        if(idx==nums.length){
            if(currsum==target) return 1;
            else return 0;
        }
        int takep =solve(nums,idx+1,currsum+nums[idx],target);
        int takem =solve(nums,idx+1,currsum-nums[idx],target);
        return takep+takem;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length;
        int currsum =0;
        return solve(nums,0,currsum,target);
        
    }
}