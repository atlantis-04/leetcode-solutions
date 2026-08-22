class Solution {
    static int[][] dp;

    static int solve(int[] arr, int target, int i) {

        if (i >= arr.length) { 
            return target == 0 ? 1 : 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target];

        int skip = solve(arr, target, i + 1);

        int take = 0;

        if (arr[i] <= target) {
            take = solve(arr, target - arr[i], i + 1);
        }

        return dp[i][target] = take + skip;
    }

    static int perfectSum(int[] arr, int target) {

        dp = new int[arr.length][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, target, 0);
    }
}