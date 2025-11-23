import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int maxTime = 0;

        // Initialize queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // {row, col, time}
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1], time = node[2];
            maxTime = Math.max(maxTime, time);

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                    // This fresh orange rots
                    grid[newR][newC] = 2;
                    freshOranges--;
                    queue.offer(new int[]{newR, newC, time + 1});
                }
            }
        }

        // Final check for remaining fresh oranges
        return freshOranges == 0 ? maxTime : -1;
    }
}