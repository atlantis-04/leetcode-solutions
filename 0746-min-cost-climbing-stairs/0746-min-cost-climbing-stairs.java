
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n + 2];

        dp[n] = 0;
        dp[n + 1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int first = cost[i] + dp[i + 1];
            int second = cost[i] + dp[i + 2];

            dp[i] = Math.min(first, second);
        }

        return Math.min(dp[0], dp[1]);
    }
}
