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
    public TreeNode build(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int Rsubtree = end +1 ;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > root.val) {
                Rsubtree = i;
                break;
            }
        }
        root.left = build(preorder, start + 1, Rsubtree - 1);
        root.right = build(preorder, Rsubtree, end);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n == 0) return null;
        int Rsubtree = n;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0;i < n;i++){
            if(preorder[i] > root.val){
                Rsubtree = i;
                break;
            }
        }
        root.left = build(preorder, 1, Rsubtree-1);
        root.right = build(preorder, Rsubtree, n-1);
        return root;
    }
}