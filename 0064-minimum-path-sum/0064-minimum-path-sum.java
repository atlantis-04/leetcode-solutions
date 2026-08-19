class Solution {
    private int[][] dp;
    private int m, n;
    public int solve(int i, int j ,int[][] arr){
        if(i>=m || j >=n) return Integer.MAX_VALUE;
        if(i == m-1 && j == n-1) return arr[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i,j+1, arr);
        int down = solve(i+1,j,arr);

        int newsum = Math.min(right, down);

        return dp[i][j] = arr[i][j] + newsum;

    }
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,grid);
    }
}