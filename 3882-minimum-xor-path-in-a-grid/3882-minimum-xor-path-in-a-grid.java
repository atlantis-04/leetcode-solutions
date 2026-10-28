class Solution {
    int n, m;
    int[][][] dp;

    public int solve(int[][] grid, int i, int j, int xor) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        xor ^= grid[i][j];

        if (i == n - 1 && j == m - 1) {
            return xor;
        }
        if (dp[i][j][xor] != -1) {
            return dp[i][j][xor];
        }

        int right_xor = solve(grid, i, j + 1, xor);
        int down_xor = solve(grid, i + 1, j, xor);

        return dp[i][j][xor] = Math.min(right_xor, down_xor);
    }

    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][1024];

        for (int[][] row : dp) {
            for (int[] arr : row) {
                Arrays.fill(arr, -1);
            }
        }

        return solve(grid, 0, 0, 0);
    }
}
