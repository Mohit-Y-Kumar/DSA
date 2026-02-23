class Solution {
    public int coinChange(int[] coins, int amount) {
        int n =coins.length;
        int W= amount;
         int INF = (int)1e9;
        int dp[][] =new int [n+1][W+1];

        for(int i =0;i<n+1;i++){ //0th col
             dp[i][0] =0;
           

        }
        for(int j =1;j<W+1;j++){//0th row
             dp[0][j] =INF;
        }

        for(int i =1;i<n+1;i++){
            for(int j =1;j<W+1;j++){
                int c =coins[i-1];
                if(c<=j){ //valid
                dp[i][j] =Math.min(1+dp[i][j-c],dp[i-1][j]) ;

                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
         return dp[n][W] >= INF ? -1 : dp[n][W];
    }
}