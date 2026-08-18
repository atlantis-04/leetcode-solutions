class Solution {

    public int solve(int[] nums, int i, int n, int[] dp) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(nums, i + 2, n, dp);
        int skip  = solve(nums, i + 1, n, dp);

        return dp[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = solve(nums, 0, n - 2, dp1);
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }
}