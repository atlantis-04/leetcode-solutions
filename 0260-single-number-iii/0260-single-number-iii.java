class Solution {
    public int[] singleNumber(int[] nums) {

        int first = -1;
        int second = -1;

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                if (first == -1) {
                    first = nums[i];
                } else {
                    second = nums[i];
                    break;
                }
            }
        }

        return new int[]{first, second};
    }
}