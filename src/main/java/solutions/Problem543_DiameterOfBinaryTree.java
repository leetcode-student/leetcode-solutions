package solutions;

public class Problem543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter diameter = diameterOfBinaryTreeHelper(root);

        return Math.max(diameter.throughRoot, diameter.any);
    }

    private Diameter diameterOfBinaryTreeHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            Diameter diameterChild = new Diameter();
            diameterChild.throughRoot = 0;
            diameterChild.any = 0;
            return diameterChild;
        }

        Diameter diameterNull = new Diameter();
        diameterNull.throughRoot = -1;
        diameterNull.any = 0;

        Diameter left = root.left != null ? diameterOfBinaryTreeHelper(root.left) : diameterNull;
        Diameter right = root.right != null ? diameterOfBinaryTreeHelper(root.right) : diameterNull;

        /*System.out.println("root.val=" + root.val);
        System.out.println("left.throughRoot=" + left.throughRoot);
        System.out.println("left.any=" + left.any);
        System.out.println("right.throughRoot=" + left.throughRoot);
        System.out.println("right.any=" + right.any);
        System.out.println();*/

        Diameter diameterRoot = new Diameter();
        diameterRoot.throughRoot = 0;
        diameterRoot.any = 0;

        diameterRoot.throughRoot = 1 + Math.max(left.throughRoot, right.throughRoot);

        diameterRoot.any = 2 + left.throughRoot + right.throughRoot;
        diameterRoot.any = Math.max(diameterRoot.any, left.any);
        diameterRoot.any = Math.max(diameterRoot.any, right.any);

        return diameterRoot;
    }

    private static class Diameter {
        int throughRoot;
        int any;
    }
}
