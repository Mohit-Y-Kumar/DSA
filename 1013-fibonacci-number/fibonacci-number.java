class Solution {
    public int fib(int n) {
        int[] dp =new int[n+1];
        for(int i =0;i<=n;i++){
            dp[i] =-1;
        }
        return findfibo(n,dp);
        
    }
    public int findfibo(int n ,int [] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] =findfibo(n-1,dp)+findfibo(n-2,dp);

    }
}