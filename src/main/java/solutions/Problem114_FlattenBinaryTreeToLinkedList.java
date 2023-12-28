package solutions;

public class Problem114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        //System.out.println("root.val=" + root.val);

        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;
        root.right = null;

        TreeNode leftEnd = flattenHelper(left);
        TreeNode rightEnd = flattenHelper(right);

        if (left != null && right != null) {
            root.right = left;
            leftEnd.right = right;
            return rightEnd;
        } else if (left != null) {
            root.right = left;
            return leftEnd;
        } else if (right != null) {
            root.right = right;
            return rightEnd;
        } else {
            return root;
        }
    }
}
