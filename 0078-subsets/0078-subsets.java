class Solution {
    // 1. Use the interface type 'List' for the declaration
    List<List<Integer>> list = new ArrayList<>();

    public void solve(int[] nums, int index, List<Integer> sublist) {
        if (index >= nums.length) {
            // Add a copy of the current sublist to the result
            list.add(new ArrayList<>(sublist));
            return;
        }
        
        // Pick the number
        sublist.add(nums[index]);
        solve(nums, index + 1, sublist);
        
        // Skip the number (backtrack)
        sublist.remove(sublist.size() - 1);
        solve(nums, index + 1, sublist);
    }

    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return list;
    }
}   