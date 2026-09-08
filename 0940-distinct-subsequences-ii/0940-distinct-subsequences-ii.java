class Solution {
    static final int MOD = 1_000_000_007;
    long[] dp;

    public long solve(String s, int i) {
        // Empty subsequence
        if (i < 0) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Don't take s[i]
        long skip = solve(s, i - 1);

        // Take s[i]
        long take = solve(s, i - 1);

        long ans = (skip + take) % MOD;

        // Find previous occurrence of s[i]
        int j = i - 1;

        while (j >= 0 && s.charAt(j) != s.charAt(i)) {
            j--;
        }

        // Remove duplicate subsequences
        if (j >= 0) {
            ans = (ans - solve(s, j - 1) + MOD) % MOD;
        }

        return dp[i] = ans;
    }

    public int distinctSubseqII(String s) {
        int n = s.length();

        dp = new long[n];

        Arrays.fill(dp, -1);

        // -1 because solve() includes empty subsequence
        return (int) ((solve(s, n - 1) - 1 + MOD) % MOD);
    }
}