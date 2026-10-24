import java.util.*;

class pairs {
    int row;
    int col;
    int tm;

    pairs(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pairs> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        // Initial setup
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pairs(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int tm = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            pairs p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.tm;
            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.offer(new pairs(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        return cnt == cntFresh ? tm : -1;
    }
}
