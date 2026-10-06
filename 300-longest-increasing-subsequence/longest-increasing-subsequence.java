class Solution {
    int solve(int idx,int prev,int nums [],int dp[][]){
        //base case
        if(idx>=nums.length){
            return 0;
        }
        if(prev !=-1 && dp[idx][prev] !=-1){
            return dp[idx][prev];
        }
        //
        int take=0;
        if(prev == -1 || nums[prev]<nums[idx]){
             take =1+solve(idx+1,idx,nums,dp);
        }
        int skip =solve(idx+1,prev,nums,dp);

        if(prev!=-1){
            dp[idx][prev] =Math.max(take,skip);
        }

        return  Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][] =new int [nums.length+1][nums.length +1];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
    
    return  solve(0,-1,nums,dp);
        
    }
}