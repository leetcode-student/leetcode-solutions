package solutions;

import java.util.*;

public class Problem199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        traverse(root, 0, rightSideView);
        return rightSideView;
    }

    private void traverse(TreeNode root, int level, List<Integer> rightSideView) {
        if (root == null) {
            return;
        }

        if (level == rightSideView.size()) {
            rightSideView.add(root.val);
        }

        traverse(root.right, level + 1, rightSideView);
        traverse(root.left, level + 1, rightSideView);
    }
}
