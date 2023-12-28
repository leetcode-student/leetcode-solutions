package solutions;

public class Problem98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        boolean leftIsValidBST = isValidBST(root.left, min, root.val);
        boolean rightIsValidBST = isValidBST(root.right, root.val, max);

        //System.out.println("leftIsValidBST=" + leftIsValidBST);
        //System.out.println("rightIsValidBST=" + rightIsValidBST);

        return leftIsValidBST && rightIsValidBST;
    }
}
