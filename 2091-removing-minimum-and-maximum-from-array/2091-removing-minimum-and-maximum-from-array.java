class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = n - 1;

        int m1 = i + (j - i) / 2;
        int m2 = i + (j - i) / 2;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int max_index = -1;
        int min_index = -1;

        while (m1 >= 0) {
            if (nums[m1] > max) {
                max = nums[m1];
                max_index = m1;
            }

            if (nums[m1] < min) {
                min = nums[m1];
                min_index = m1;
            }

            m1--;
        }

        while (m2 < n) {
            if (nums[m2] > max) {
                max = nums[m2];
                max_index = m2;
            }

            if (nums[m2] < min) {
                min = nums[m2];
                min_index = m2;
            }

            m2++;
        }

        // Make sure min_index is the smaller index
        // and max_index is the larger index.
        int left = Math.min(min_index, max_index);
        int right = Math.max(min_index, max_index);

        // Remove both elements from the left
        int remove_left = right + 1;

        // Remove both elements from the right
        int remove_right = n - left;

        // Remove one from left and one from right
        int remove_both = (left + 1) + (n - right);

        return Math.min(remove_left, Math.min(remove_right, remove_both));
    }
}