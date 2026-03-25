class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m =grid.length;
        int  n=grid[0].length;
        int rowSum [] =new int [m];
        int colSum [] =new int [n];
        long totSum=0;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                totSum +=grid[i][j];

                //rowSum -> store each row sum
                rowSum[i] +=grid[i][j];

                //colSum => store each col sum
                colSum[j] += grid[i][j];
            }
        }
        if(totSum%2!=0){
            return false;
        }

         // horizontal split
        long upSum =0;
        for(int i =0;i<m-1;i++){
            upSum +=rowSum[i];
            if(upSum ==totSum -upSum){
                return true;
            }
        }


        //vertical split
        long leftSum =0;
        for(int j =0;j<n-1;j++){
           leftSum +=colSum[j];
           if(leftSum == totSum -leftSum){
            return true;
           }
        }

        return false;
    }
}