package solutions;

import java.util.*;

public class Problem173_BinarySearchTreeIterator {
    private Stack<TreeNode> dfs;

    public BSTIterator(TreeNode root) {
        dfs = new Stack<TreeNode>();
        while (root != null) {
            dfs.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = dfs.pop();
        int next = node.val;

        TreeNode right = node.right;
        while (right != null) {
            dfs.add(right);
            right = right.left;
        }

        return next;
    }

    public boolean hasNext() {
        return !dfs.isEmpty();
    }
}
