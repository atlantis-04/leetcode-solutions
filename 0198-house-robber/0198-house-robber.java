// class Solution {
  
//     public int solve(int[] nums, int i){
//         if(i >= nums.length){
//             return 0;
//         }
//         if(dp[i] != -1) return dp[i];

//         int take = nums[i] + solve(nums, i+2);
//         int skip = solve(nums, i +1);
//         return dp[i] = Math.max(take, skip);
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return solve(nums, 0);
//     }
// }
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev = 0;      // dp[i+1]
        int preprev = 0;   // dp[i+2]

        for (int i = n - 1; i >= 0; i--) {

            int rob = nums[i] + preprev;
            int skip = prev;

            int curr = Math.max(rob, skip);

            preprev = prev;
            prev = curr;
        }

        return prev;
    }
}