import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Store the initial index of each number
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], i);
        }

        // Apply operations
        for (int[] it : operations) {
            int a = it[0]; 
            int b = it[1]; 
            int ind = freq.get(a);
            
            // Replace the element at the stored index
            nums[ind] = b;

            // Update the map: remove old value and insert new value with the same index
            freq.remove(a);
            freq.put(b, ind);
        }
        
        return nums;
    }
}