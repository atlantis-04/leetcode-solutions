class Solution {
    static int[][] dp;

    static boolean solve(int[] arr, int i, int sum) {

        // Found required sum
        if (sum == 0)
            return true;

        // No elements left
        if (i == arr.length)
            return false;

        // Already calculated
        if (dp[i][sum] != -1)
            return dp[i][sum] == 1;

        // Skip current element
        boolean skip = solve(arr, i + 1, sum);

        // Take current element (only if it doesn't exceed sum)
        boolean take = false;
        if (arr[i] <= sum) {
            take = solve(arr, i + 1, sum - arr[i]);
        }

        boolean ans = take || skip;

        dp[i][sum] = ans ? 1 : 0;

        return ans;
    }

    static boolean isSubsetSum(int arr[], int sum) {

        dp = new int[arr.length][sum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(arr, 0, sum);
    }
}