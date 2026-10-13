class Solution {
     public static void sortByAbsoluteDescending(int[] arr) {
        // Convert int[] to Integer[] for using Comparator
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort by absolute value in descending order
        Arrays.sort(temp, (a, b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        // Copy back to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
    
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0]*nums[0];
        sortByAbsoluteDescending(nums);
        long sum1 =0;
        long sum2 = 0;
        if(n % 2!= 0){
            for(int i=0;i<=n/2;i++){
                sum1 += (long)nums[i] * nums[i];

            }
            for(int i=(n/2)+1;i<n;i++){
                sum2 += (long)nums[i] * nums[i];
            }
        }
        else{
            for(int i=0;i<=(n/2)-1;i++){
                sum1 += (long)nums[i] * nums[i];
            }
            for(int i=n/2;i<n;i++){
                sum2 += (long)nums[i] * nums[i];
            }
        }
        return Math.abs(sum2-sum1);
    }
}