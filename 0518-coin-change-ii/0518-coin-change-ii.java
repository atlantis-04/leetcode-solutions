class Solution {
    // int n;
    // int[][] dp = new int[301][5001];
    // int solve(int i,  int[] coins,int amount) {
    //     if (amount == 0)
    //         return dp[i][amount] = 1;
    //     if (i == n || amount < 0)
    //         return 0;
    //     if (dp[i][amount] != -1)
    //         return dp[i][amount];
    //     if (coins[i] > amount)
    //         return dp[i][amount] = solve(i + 1, coins, amount);
    //     int take = solve(i, coins, amount - coins[i]);
    //     int skip = solve(i + 1, coins, amount);

    //     return dp[i][amount] = take + skip;
    // }

    public int change(int amount, int[] coins) {
        n = coins.length;
       for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 5001; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, coins, amount);
    }

    int n;
    int[][] dp = new int[301][5001];
    int solve(int i,  int[] coins,int amount) {
        if (amount == 0)
            return dp[i][amount] = 1;
        if (i == n || amount < 0)
            return 0;
        if (dp[i][amount] != -1)
            return dp[i][amount];
        int skip = solve(i + 1, coins, amount);

        int take = 0;
        if(coins[i] <= amount){
            take = solve(i, coins, amount - coins[i]);
        }
        
        
        return dp[i][amount] = take + skip;
    }














    //    int[] dp = new int[amount+1];
    //     dp[0] = 1;
        // dp[i] = how many different ways can we make up amount i with our coins?'
    
        // for (int coin: coins) {
        //     for (int i = coin; i <= amount; i++) {
        //         dp[i] += dp[i-coin];
        //     }
        // }

        // return dp[amount];
    // }
}
