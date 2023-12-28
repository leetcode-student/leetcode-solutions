package solutions;

import java.util.*;

public class Problem314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> leftOrder = new ArrayList<>();
        List<List<Integer>> rightOrder = new ArrayList<>();

        TreeNodeColumn rootNodeColumn = new TreeNodeColumn();
        rootNodeColumn.node = root;
        rootNodeColumn.column = 0;

        Queue<TreeNodeColumn> bfsQueue = new LinkedList<>();
        bfsQueue.add(rootNodeColumn);

        while (!bfsQueue.isEmpty()) {
            TreeNodeColumn nodeColumn = bfsQueue.poll();
            visit(nodeColumn.node, nodeColumn.column, leftOrder, rightOrder);

            if (nodeColumn.node.left != null) {
                TreeNodeColumn childColumn = new TreeNodeColumn();
                childColumn.node = nodeColumn.node.left;
                childColumn.column = nodeColumn.column - 1;
                bfsQueue.add(childColumn);
            }

            if (nodeColumn.node.right != null) {
                TreeNodeColumn childColumn = new TreeNodeColumn();
                childColumn.node = nodeColumn.node.right;
                childColumn.column = nodeColumn.column + 1;
                bfsQueue.add(childColumn);
            }
        }

        //System.out.println("leftOrder=" + leftOrder);
        //System.out.println("rightOrder=" + rightOrder);

        Collections.reverse(leftOrder);
        leftOrder.addAll(rightOrder);

        return leftOrder;
    }

    private void visit(TreeNode root, int column, List<List<Integer>> leftOrder, List<List<Integer>> rightOrder) {
        if (root == null) {
            return;
        }

        if (column < 0) {
            if (leftOrder.size() < -column) {
                leftOrder.add(new ArrayList<>());
            }
            leftOrder.get(-column - 1).add(root.val);
        } else {
            if (rightOrder.size() <= column) {
                rightOrder.add(new ArrayList<>());
            }
            rightOrder.get(column).add(root.val);
        }
    }

    private static class TreeNodeColumn {
        TreeNode node;
        int column;
    }
}
