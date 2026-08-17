class Solution {
    int dp [][];
    public int solve(int idx ,int amount ,int []coins){
        if(idx==coins.length){
            if(amount==0){
                return 1;
            }else{
                return 0;
            }
            
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int take =0;
        if(coins[idx]<=amount){
       take =solve(idx,amount-coins[idx],coins);
        }
       int skip =solve(idx+1,amount,coins);
        return dp[idx][amount]= take+skip;
    }
    public int change(int amount, int[] coins) {
        dp =new int [coins.length+1][amount+1];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
       return solve(0,amount,coins);
    }
}