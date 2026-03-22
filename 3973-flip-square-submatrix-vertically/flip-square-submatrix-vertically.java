class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int bottom = x + k - 1;

        for (int top = x; top < x + k / 2; top++) {   // outer loop (rows)
            
            for (int col = y; col < y + k; col++) {   // inner loop (columns)
                
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
            
            bottom--;   // move bottom pointer up
        }

        return grid;
    }
}