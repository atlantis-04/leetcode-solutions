class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][2];

        // Base case:
        // dp[n][0] = 0
        // dp[n][1] = 0

        for (int ind = n - 1; ind >= 0; ind--) {

            // We are allowed to buy
            dp[ind][0] = Math.max(
                dp[ind + 1][0],
                -arr[ind] + dp[ind + 1][1]
            );

            // We are allowed to sell
            dp[ind][1] = Math.max(
                dp[ind + 1][1],
                arr[ind] + dp[ind + 1][0]
            );
        }

        return dp[0][0];
    }
}