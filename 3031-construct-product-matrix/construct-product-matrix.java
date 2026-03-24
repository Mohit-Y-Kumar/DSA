class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD =12345;
        int m =grid.length;
        int n =grid[0].length;

        int[][]dp =new int[m][n];
        long suffix =1;
        for(int i=m-1;i>=0;i--){
         for(int j =n-1;j>=0;j--){
            dp[i][j] =(int)suffix;
            suffix =(suffix*grid[i][j]) % MOD;
         }
        }

       long prefix =1;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                dp[i][j] =(int)(((long)prefix*dp[i][j])% MOD); //mul left * right;
                prefix =(prefix * grid[i][j])% MOD; //update prefix for next el
            }
        }
        return dp;
        
    }
}