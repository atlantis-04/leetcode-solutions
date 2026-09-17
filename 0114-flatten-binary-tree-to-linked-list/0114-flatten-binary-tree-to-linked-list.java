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
    TreeNode nextRight = null;
    public void flatten(TreeNode root) {

// here we have used the reverse pre order traversal i.e. ppehle right se gye then left gye, so that ham jab 4->5 ko connect krte h toh easy connection can be made.
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = nextRight;
        nextRight = root;

    }
}