class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int m =grid.length;
        int n =grid[0].length;
        int count =0;
        int [][] dp =new int [m+1][n+1];

       for(int i = 1; i <= m; i++){
         for(int j = 1; j <= n; j++){
              dp[i][j] = grid[i-1][j-1] 
                    + dp[i-1][j] 
                    + dp[i][j-1] 
                    - dp[i-1][j-1];
                if(dp[i][j]<=k){
                    count++;
                }else{
                   break;
                   }
            }
        }
        return count;
    }
}