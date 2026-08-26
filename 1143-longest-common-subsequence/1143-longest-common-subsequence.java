class Solution {
    int[][] dp;
    public int solve(int i, int j, String s, String d) {
    if (i == s.length() || j == d.length())
        return 0;

    if (dp[i][j] != -1)
        return dp[i][j];

    if (s.charAt(i) == d.charAt(j)) {
        return dp[i][j] = 1 + solve(i + 1, j + 1, s, d);
    }

    int skipa = solve(i + 1, j, s, d);
    int skipb = solve(i, j + 1, s, d);

    return dp[i][j] = Math.max(skipa, skipb);
}
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,text1,text2);
    }
}