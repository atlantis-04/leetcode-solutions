class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count1 = 1;
        int count2 = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count1++;
            } else {
                count1 = 1;
            }

            max = Math.max(max, count1);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count2++;
            } else {
                count2 = 1;
            }

            max = Math.max(max, count2);
        }

        return max;
    }
}