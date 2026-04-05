import java.util.*;

class Solution {

    private Integer[][] dp;
    private int[][] robots; // [position, distance]
    private int[] walls;
    private int n;

    public int maxWalls(int[] robotsInput, int[] distance, int[] wallsInput) {
        n = robotsInput.length;
        robots = new int[n][2];
        for (int i = 0; i < n; i++) {
            robots[i][0] = robotsInput[i];
            robots[i][1] = distance[i];
        }
        Arrays.sort(robots, Comparator.comparingInt(a -> a[0]));
        walls = wallsInput.clone();
        Arrays.sort(walls);

        dp = new Integer[n][2];
        return dfs(n - 1, 1);  // start from last robot, dummy prev direction = 1 (right)
    }

    private int dfs(int i, int prevDir) {  // prevDir: 0 = previous fired left, 1 = previous fired right
        if (i < 0) return 0;
        if (dp[i][prevDir] != null) return dp[i][prevDir];

        int pos = robots[i][0];
        int dist = robots[i][1];

        int ans = 0;

        // Option 1: Fire LEFT
        int leftL = pos - dist;
        if (i > 0) {
            leftL = Math.max(leftL, robots[i - 1][0] + 1);
        }
        int leftR = pos;
        int leftCount = count(leftL, leftR);
        int leftTotal = leftCount + dfs(i - 1, 0);

        // Option 2: Fire RIGHT
        int rightR = pos + dist;
        if (i + 1 < n) {
            int nextPos = robots[i + 1][0];
            int nextDist = robots[i + 1][1];
            if (prevDir == 0) {  // next robot fires left → can reach farther left
                rightR = Math.min(rightR, nextPos - nextDist - 1);
            } else {
                rightR = Math.min(rightR, nextPos - 1);
            }
        }
        int rightL = pos;
        int rightCount = count(rightL, rightR);
        int rightTotal = rightCount + dfs(i - 1, 1);

        ans = Math.max(leftTotal, rightTotal);
        return dp[i][prevDir] = ans;
    }

    // Count walls in [L, R] inclusive
    private int count(int L, int R) {
        if (L > R) return 0;
        int leftIdx = lowerBound(L);
        int rightIdx = lowerBound(R + 1) - 1;
        return Math.max(0, rightIdx - leftIdx + 1);
    }

    private int lowerBound(int target) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (walls[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}