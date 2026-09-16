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

// Class to represent a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    // Constructor to initialize node
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to count nodes in a complete binary tree
    public int countNodes(TreeNode root) {
        // If tree is empty, return 0
        if (root == null) {
            return 0;
        }
        // Get left height
        int lh = findHeightLeft(root);
        // Get right height
        int rh = findHeightRight(root);
        // If heights match, use perfect binary tree formula
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        // Otherwise, recursively count left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Helper to find height from leftmost path
    public int findHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Helper to find height from rightmost path
    public int findHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // Create solution object
        Solution sol = new Solution();

        // Count total nodes
        int totalNodes = sol.countNodes(root);

        // Print result
        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }
}
