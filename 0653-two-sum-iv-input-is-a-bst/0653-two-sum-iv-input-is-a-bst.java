
class Solution {
    /*
       Helper function to extract tree values in strictly increasing order
    */
    private void inorder(TreeNode root, List<Integer> nums) {
        // Base case: stop if the node is empty
        if (root == null) {
            return;
        }
        
        // Traverse the left side completely
        inorder(root.left, nums);
        // Store the current node's value
        nums.add(root.val);
        // Traverse the right side completely
        inorder(root.right, nums);
    }

    /*
       Main function to find the target sum using a list and two pointers
    */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        // Flatten the BST into a sorted list
        inorder(root, nums);
        
        // Initialize pointers at the extreme ends of the list
        int left = 0;
        int right = nums.size() - 1;
        
        // Loop to check pairs until the pointers cross
        while (left < right) {
            int currentSum = nums.get(left) + nums.get(right);
            
            // If the exact target is found, return true
            if (currentSum == k) {
                return true;
            }
            
            // If the sum is too small, move to a larger number on the left
            if (currentSum < k) {
                left++;
            } 
            // If the sum is too large, move to a smaller number on the right
            else {
                right--;
            }
        }
        
        // No valid pairs exist
        return false;
    }
}

