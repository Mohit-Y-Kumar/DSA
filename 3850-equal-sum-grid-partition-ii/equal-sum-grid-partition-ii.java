class Solution {
    boolean checkHoriZontalCuts(int[][] grid,long totalSum){
        int m =grid.length;
        int n =grid[0].length;
        HashSet<Long> set = new HashSet<>();
        long top =0;
       for(int i =0;i<m-1;i++){
            for(int j =0;j<n;j++){
                set.add((long)grid[i][j]);
                top +=grid[i][j];
            } 
                long bottom =totalSum - top;
                long diff =top -bottom;
                if(diff==0) return true;
                if(diff==(long)grid[0][0]) return true;
                if(diff==(long)grid[0][n-1]) return true;
                if(diff==(long)grid[i][0]) return true;
                if(i>0 && n>1 && set.contains(diff)) return true;

            
            
        }

        return false;
              
    }
    void reverse(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    for (int j = 0; j < n; j++) {      
        int top = 0, bottom = m - 1;    
        while (top < bottom) {
            int temp = grid[top][j];     
            grid[top][j] = grid[bottom][j];
            grid[bottom][j] = temp;
            top++;
            bottom--;
        }
    }
}

    int[][] transpose(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] transPoseGrid = new int[n][m];
            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    transPoseGrid[j][i] = grid[i][j];
                }
            }
            return transPoseGrid;
    }
    public boolean canPartitionGrid(int[][] grid) {
        long totalSum =0;
        int m =grid.length;
        int n =grid[0].length;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                totalSum +=grid[i][j];

            }
        }
        //Horizontal cuts

        if(checkHoriZontalCuts(grid,totalSum)){
            return true;
        }
         
        reverse(grid);

        if(checkHoriZontalCuts(grid,totalSum)){
            return true;
        }

        reverse(grid);  //original grid for transpose

        //verticlecut =>transpose of grid and do checkHoriZontalCuts(grid)
        
        int[][]t =transpose(grid);

         //Horizontal cuts

        if(checkHoriZontalCuts(t,totalSum)){
            return true;
        }
         
        reverse(t);
        if(checkHoriZontalCuts(t,totalSum)){
            return true;
        }
        return false;
    }
}