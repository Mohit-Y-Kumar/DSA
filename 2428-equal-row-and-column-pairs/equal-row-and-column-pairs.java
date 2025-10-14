class Solution {
    public int equalPairs(int[][] grid) {
        // int count=0;
        // for(int r =0;r<grid.length;r++){
        //     for(int c =0;c<grid.length;c++){
        //         boolean isEqual =true;
        //         for(int i =0;i<grid.length;i++){
        //             if(grid[r][i] != grid[i][c]){
        //                 isEqual  =false;
        //             }
        //         }
        //         if(isEqual ==true){
        //             count++;
        //         }
        //     }
        // }

        // return count;
        
        int n =grid.length;
        int count =0;
       HashMap<String,Integer> has =new HashMap<>();
        for(int r =0;r<n;r++){
         String row = Arrays.toString(grid[r]);
            has.put(row, has.getOrDefault(row, 0) + 1);
        }
        for(int j =0;j<n;j++){
            int[] col =new int[n];
            for(int i =0;i<n;i++){
                col[i] =grid[i][j];
            }
            String colVal = Arrays.toString(col);
            if(has.containsKey(colVal)){
              count +=has.get(colVal);
            }
        }
        return count;
    }

}