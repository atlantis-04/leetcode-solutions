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
    public boolean isSameTree(TreeNode p, TreeNode q) {

    // If both are null → identical up to this branch
    if (p == null && q == null) return true;

    // If only one is null or values differ → not the same
    if (p == null || q == null || p.val != q.val) return false;

    // Recurse on left and right children
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }
}

//  if(p== null && q == null){
//             return true;
//         }
//         if(p.left != q.left && p.right != q.right) return false;
//         // if(p.right != q.right) return false;   

//         return true;  