class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallest = Integer.MAX_VALUE;
        int total_odd = 0;

        for(int num : nums1){
            if(num < smallest){
                smallest = num;
            }
            if(num % 2 != 0){
                total_odd++;
            }
        }
        if(total_odd == 0 || total_odd == nums1.length){
            return true;
        }
        if(smallest % 2 != 0){
            return true;
        }

        return false;
    }
}