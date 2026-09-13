class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, List<Integer> sublist, boolean[] used) {
        int n = nums.length;

        if (sublist.size() == n) {
            result.add(new ArrayList<>(sublist)); // copy
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            used[i] = true;
            sublist.add(nums[i]);

            solve(nums, sublist, used);

            sublist.remove(sublist.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        solve(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
}