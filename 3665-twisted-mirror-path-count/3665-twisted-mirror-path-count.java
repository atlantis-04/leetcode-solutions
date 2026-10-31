import java.util.*;

class Solution {
    int[][][] dp;
    int n, m;
    int MOD = 1000000007;

    public int solve(int i, int j, int dir, int[][] grid) {

        if (i >= n || j >= m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        long ans = 0;
        if (grid[i][j] == 1) {

            if (dir == 0) {
                ans = solve(i + 1, j, 1, grid);
            } else {
                ans = solve(i, j + 1, 0, grid);
            }

        } else {
            ans += solve(i, j + 1, 0, grid);
            ans += solve(i + 1, j, 1, grid);
        }

        return dp[i][j][dir] = (int)(ans % MOD);
    }

    public int uniquePaths(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][2];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        if (n == 1 && m == 1) {
            return 1;
        }

        if (grid[0][0] == 1) {
            // Start is not entered by a movement,
            // so allow both initial choices.
            return (int)(((long) solve(0, 1, 0, grid)
                         + solve(1, 0, 1, grid)) % MOD);
        }

        return solve(0, 0, 0, grid);
    }
}