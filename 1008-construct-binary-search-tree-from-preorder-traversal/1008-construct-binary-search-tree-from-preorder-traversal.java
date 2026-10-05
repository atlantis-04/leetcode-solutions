class Solution {

    public TreeNode build(int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);

        int Rsubtree = end + 1;

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
        return build(preorder, 0, preorder.length - 1);
    }
}