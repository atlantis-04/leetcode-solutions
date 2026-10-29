
class Solution {
    private int m, n;

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;

        int sum = 1;

        grid[r][c] = 0;

        sum += dfs(grid, r, c - 1);
        sum += dfs(grid, r, c + 1);
        sum += dfs(grid, r - 1, c);
        sum += dfs(grid, r + 1, c);

        return sum;
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int max_area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    max_area = Math.max(area, max_area);
                }
            }
        }

        return max_area;
    }
}
