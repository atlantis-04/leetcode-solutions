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
    public int sum(TreeNode root) {
        if (root == null)
            return 0;

        return root.val + sum(root.left) + sum(root.right);
    }
    public int count(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + count(root.left) + count(root.right);
    }
    public int average(TreeNode root) {
        if (root == null)
            return 0;

        return sum(root) / count(root);
    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;

        if (root.val == average(root))
            ans++;

        ans += averageOfSubtree(root.left);
        ans += averageOfSubtree(root.right);

        return ans;
    }
    
}