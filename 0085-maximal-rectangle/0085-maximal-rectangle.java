class Solution {
    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;

                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int minWidth = Integer.MAX_VALUE;

                for (int k = i; k >= 0; k--) {

                    minWidth = Math.min(minWidth, dp[k][j]);

                    int height = i - k + 1;

                    int area = minWidth * height;

                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }
}