class Solution {
    List<List<Integer>> result = new ArrayList<>();
    // since we have to try all possible outcomes we use recursion, and backtracking 
    public void backtrack(int index, List<Integer> list, int n,int[] nums){
        if(index == n){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(index+1, list, n, nums);
        list.remove(list.size()-1);
        backtrack(index+1,list,n,nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, n, nums);
        return result;
    }
}