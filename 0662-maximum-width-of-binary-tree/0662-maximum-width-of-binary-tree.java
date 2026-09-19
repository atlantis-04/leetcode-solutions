import java.util.*;

class Solution {

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0L));

        long maxWidth = 0;

        while (!que.isEmpty()) {
            int n = que.size();

            long f = que.peek().index;
            long l = 0;

            for (Pair p : que) {
                l = p.index;
            }

            maxWidth = Math.max(maxWidth, l - f + 1);

            while (n-- > 0) {
                Pair p = que.poll();

                TreeNode curr = p.node;
                long d = p.index;

                if (curr.left != null) {
                    que.offer(new Pair(curr.left, 2 * d + 1));
                }

                if (curr.right != null) {
                    que.offer(new Pair(curr.right, 2 * d + 2));
                }
            }
        }

        return (int) maxWidth;
    }
}