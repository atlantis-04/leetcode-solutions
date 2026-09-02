class Solution {

    public int getAns(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {

        // Base case
        if (ind == n || cap == 0)
            return 0;

        // Already calculated
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit;

        if (buy == 0) {
            // Buy or skip
            profit = Math.max(
                getAns(prices, n, ind + 1, 0, cap, dp),
                -prices[ind] + getAns(prices, n, ind + 1, 1, cap, dp)
            );
        } else {
            // Sell or skip
            profit = Math.max(
                getAns(prices, n, ind + 1, 1, cap, dp),
                prices[ind] + getAns(prices, n, ind + 1, 0, cap - 1, dp)
            );
        }

        return dp[ind][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[ind][buy][cap]
        int[][][] dp = new int[n][2][3];

        // Initialize with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return getAns(prices, n, 0, 0, 2, dp);
    }
}