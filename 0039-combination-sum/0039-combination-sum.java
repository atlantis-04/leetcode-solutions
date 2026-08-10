class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, int index, int target,
                      ArrayList<Integer> sublist){

        if(target == 0){
            result.add(new ArrayList<>(sublist));
            return;
        }

        if(index >= nums.length || target < 0){
            return;
        }

        sublist.add(nums[index]);
        solve(nums, index, target - nums[index], sublist);

        sublist.remove(sublist.size() - 1);

        solve(nums, index + 1, target, sublist);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        solve(nums, 0, target, new ArrayList<>());
        return result;
    }
}