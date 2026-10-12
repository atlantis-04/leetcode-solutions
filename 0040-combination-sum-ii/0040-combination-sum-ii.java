class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int index, int n, int[] nums,
                          int target, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (index >= n || target < 0) {
            return;
        }

        // TAKE current element
        list.add(nums[index]);
        backtrack(index + 1, n, nums, target - nums[index], list);

        // BACKTRACK
        list.remove(list.size() - 1);

        // SKIP all consecutive duplicates
        int idx = index + 1;

        while (idx < n && nums[idx] == nums[index]) {
            idx++;
        }

        // SKIP branch
        backtrack(idx, n, nums, target, list);
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        backtrack(0, n, nums, target, list);

        return result;
    }
}