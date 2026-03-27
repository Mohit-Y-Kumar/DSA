class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // store original matrix
        int[][] original = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                original[i][j] = mat[i][j];
            }
        }

        // optimize k
        k = k % n;

        // apply shift k times
        for(int i = 0; i < k; i++){
            mat = shift(mat);
        }

        // compare with original
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != original[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] shift(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i % 2 == 0){
                    temp[i][j] = grid[i][(j + 1) % n]; // left shift
                } else {
                    temp[i][j] = grid[i][(j - 1 + n) % n]; // right shift
                }
            }
        }
        return temp;
    }
}