class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }
        for(int num : nums){
            sum += Math.abs(num-max);
        }
        return sum;
    }
}