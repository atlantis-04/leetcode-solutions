class Solution {
    public int sumCounts(List<Integer> nums) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.size();
        for(int i = 0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i;j<n;j++){
                set.add(nums.get(j));
                list.add(set.size());
            }
            
        }
        int sum = 0;
        for(int num : list){
            sum += num * num;
        }
        return sum;
    }
}