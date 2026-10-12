class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void backtrack(int index, List<Integer> temp, int[] nums) {

        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // TAKE
        temp.add(nums[index]);
        backtrack(index + 1, temp, nums);

        // UNDO
        temp.remove(temp.size() - 1);

        // SKIP DUPLICATES
        int next = index + 1;

        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }

        // SKIP
        backtrack(next, temp, nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return result;
    }
}