class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum =0;
        
        for(int i=0;i<n;i++){
            totalsum +=nums[i];
        }
        if(totalsum %2 !=0){
          return false;
        }
        int target =totalsum/2;
        int [][] dp =new int [n+1][target+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       return solve(n-1,nums,target,dp);

        
        
    }
    public boolean solve(int idx,int nums[],int target,int[] [] dp){
        if(target ==0) return true;
        if(idx ==0) return nums[0] ==target;
        
        if(dp[idx][target] != -1) return dp[idx][target] ==1;
        boolean  skip = solve(idx-1,nums,target,dp);

        boolean take =false;
        if(nums[idx]<=target){
         take =solve(idx-1,nums,target-nums[idx],dp);
        }
         dp[idx][target] =(take || skip) ?1 :0;
        return take ||skip;
    }
}