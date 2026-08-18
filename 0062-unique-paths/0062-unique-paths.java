class Solution {
    int[][] dp;
    public int solve(int m, int n,int i, int j ){
        if(i >=m || j >=n) {return 0;}
        if(i == m-1 && j == n-1) {return 1;}
        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int right = solve(m,n,i ,j+1);
        int down = solve(m,n,i+1,j);

        dp[i][j] = right + down;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return solve(m,n,0,0);
    }
}