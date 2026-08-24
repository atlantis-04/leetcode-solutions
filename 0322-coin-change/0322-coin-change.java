// class Solution {
//     int[][] dp;
//     final int INF = (int) 1e9;

//     public int solve(int i, int[] coins, int amount) {

//         if (amount == 0)
//             return 0;

//         if (i == coins.length)
//             return INF;

//         if (dp[i][amount] != -1)
//             return dp[i][amount];

//         int take = INF;

//         if (coins[i] <= amount) {
//             take = 1 + solve(i, coins, amount - coins[i]);
//         }

//         int notTake = solve(i + 1, coins, amount);

//         return dp[i][amount] = Math.min(take, notTake);
//     }

//     public int coinChange(int[] coins, int amount) {
//         dp = new int[coins.length][amount + 1];

//         for (int[] row : dp)
//             Arrays.fill(row, -1);

//         int ans = solve(0, coins, amount);

//         return ans >= INF ? -1 : ans;

//         dp[n][0] = 0;

//         for(int j = 1;j <= amount; j++){
//             d[n][j] = INF;
//         }


//     }
// }
class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int INF = (int)1e9;

        int[][] dp = new int[n + 1][amount + 1];

        // Base case:
        // solve(n,0) = 0
        // solve(n,amount>0) = INF
        dp[n][0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[n][j] = INF;
        }

        // Fill from bottom to top because we need dp[i+1][...]
        for (int i = n - 1; i >= 0; i--) {

            // solve(i,0) = 0
            dp[i][0] = 0;

            for (int j = 1; j <= amount; j++) {

                int take = INF;

                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }

                int notTake = dp[i + 1][j];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[0][amount] >= INF ? -1 : dp[0][amount];
    }
}


