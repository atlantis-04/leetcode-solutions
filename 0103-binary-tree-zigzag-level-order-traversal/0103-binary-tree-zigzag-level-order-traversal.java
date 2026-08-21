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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = deque.poll();
                currentLevel.add(currentNode.val);
                
                if (currentNode.left != null) {
                    deque.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    deque.offer(currentNode.right);
                }
            }
            
            if (reverse) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            reverse = !reverse;
        }
        
        return result;
    }
}
