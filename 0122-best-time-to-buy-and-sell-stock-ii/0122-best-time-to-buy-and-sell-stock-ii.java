class Solution {
    private int getAns(int[] arr, int ind, int buy, int n, int[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit;

        if (buy == 0) {
            profit = Math.max(
                getAns(arr, ind + 1, 0, n, dp),
                -arr[ind] + getAns(arr, ind + 1, 1, n, dp)
            );
        } else {
            profit = Math.max(
                getAns(arr, ind + 1, 1, n, dp),
                arr[ind] + getAns(arr, ind + 1, 0, n, dp)
            );
        }

        dp[ind][buy] = profit;
        return profit;
    }

    public int maxProfit(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getAns(arr, 0, 0, n, dp);
    }
}