/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     private TreeNode helper(TreeNode root) {
 
        // Case 1: No left child
        if (root.left == null) {
            return root.right;
        }
 
        // Case 2: No right child
        if (root.right == null) {
            return root.left;
        }
 
        // Case 3: Both children exist
        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;
 
        // Find the leftmost node in the right subtree
        TreeNode leftmostOfRight = rightChild;
 
        while (leftmostOfRight.left != null) {
            leftmostOfRight = leftmostOfRight.left;
        }
 
        // Attach the left subtree
        leftmostOfRight.left = leftChild;
 
        // Promote the right subtree
        return rightChild;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
 
        // Target node found
        if (root.val == key) {
            return helper(root);
        }
 
        // Search in left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
 
        // Search in right subtree
        else {
            root.right = deleteNode(root.right, key);
        }
 
        return root;
    }
}