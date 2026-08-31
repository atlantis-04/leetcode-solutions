class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Put smaller index in minIndex
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // 1. Remove both from the left
        int removeFromLeft = right + 1;

        // 2. Remove both from the right
        int removeFromRight = n - left;

        // 3. Remove left element from left
        //    and right element from right
        int removeFromBoth = (left + 1) + (n - right);

        return Math.min(
            removeFromLeft,
            Math.min(removeFromRight, removeFromBoth)
        );
    }
}