class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m =grid.length;
        int n =grid[0].length;
        int[][] cumsumX =new int[m+1][n+1];
        int[][] cumsumY =new int[m+1][n+1];
        int count =0;

        for(int i =1;i<=m;i++){
            for(int j =1;j<=n;j++){
             cumsumX[i][j] =(grid[i-1][j-1] == 'X')? 1 : 0;
             cumsumY[i][j] =(grid[i-1][j-1] == 'Y')? 1 : 0;
             
             cumsumX[i][j] =cumsumX[i][j]
                            + cumsumX[i-1][j]+cumsumX[i][j-1] -cumsumX[i-1][j-1];
             cumsumY[i][j] =cumsumY[i][j]
                            + cumsumY[i-1][j]+cumsumY[i][j-1] -cumsumY[i-1][j-1];
             
                
                if( cumsumX[i][j]==cumsumY[i][j] && cumsumX[i][j]>0  ){
                    count++;
                }
            }
        }
    
        return count;
    }
}