class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target);
    }

    private boolean solve(int[] nums, int i, int remain) {

        if (remain == 0) {
            return true;
        }

        if (i == nums.length || remain < 0) {
            return false;
        }

        if (memo[i][remain] != null) {
            return memo[i][remain];
        }

        boolean take = solve(nums, i + 1, remain - nums[i]);
        boolean skip = solve(nums, i + 1, remain);

        return memo[i][remain] = take || skip;
    }
}