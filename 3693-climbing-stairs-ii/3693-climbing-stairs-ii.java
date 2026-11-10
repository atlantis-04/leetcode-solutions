class Solution {
    int[] dp;
    // public int solve(int i, int n, int[] costs) {
    //     if (i == n)
    //         return 0;
    //     if (memo[i] != -1)
    //         return memo[i];

    //     int cost = Integer.MAX_VALUE;

    //     int j = i + 1;
    //     if (j <= n)                                     
    //         cost = solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i);

    //     j = i + 2;                                     
    //     if (j <= n)
    //         cost = Math.min(cost, solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i));

    //     j = i + 3;                                  
    //     if (j <= n)
    //         cost = Math.min(cost, solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i));

    //     return memo[i] = cost;
    // }

    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        int cost = Integer.MAX_VALUE;
        for(int i = n-1; i>=0;i--){
            int j = i +1;
            if(j <= n){
                cost = dp[j] + costs[j - 1] + 1;
            }
            j = i + 2;                                  
            if (j <= n)
                cost = Math.min(cost, dp[j] + costs[j - 1] + 4);

            j = i + 3;                                 
            if (j <= n)
                cost = Math.min(cost, dp[j] + costs[j - 1] + 9);

            dp[i] = cost;
            
        }
        return dp[0];
    }
}
