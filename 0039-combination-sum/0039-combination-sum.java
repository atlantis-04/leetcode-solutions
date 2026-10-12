class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(int index, int n, int[] candidates, int target, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(index >= n || target < 0){
            return;
        }
        list.add(candidates[index]);
        backtrack(index, n, candidates, target-candidates[index],list);
        list.remove(list.size() - 1);
        backtrack(index+1,n, candidates, target, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> list = new ArrayList<>();
        backtrack(0,n, candidates,target,list);
        return result;
    }
}