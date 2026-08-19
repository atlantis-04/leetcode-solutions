class Solution {
    int[][] dp;
    int n, m;

    public int solve(int[][] arr, int i, int j) {

        if (i >= n || j >= m) return 0;

        if (arr[i][j] == 1) return 0;

        if (i == n - 1 && j == m - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(arr, i, j + 1);
        int down = solve(arr, i + 1, j);

        return dp[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] arr) {

        n = arr.length;
        m = arr[0].length;

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, 0, 0);
    }
}