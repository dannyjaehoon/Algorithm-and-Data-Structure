package easy;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        //  1
        // 2 3

        // step 1
        // root = 1
        // left = invertTree(3)
        // right = inverTree(2)

        // step 2
        // root = invertTree(3)
        // left = null
        // right = null
        // return 3

        // step 3
        // root = inverTree(2)
        // left = null
        // right = null
        // return 2

        // step 4
        // root =1
        // left = 3
        // right = 2
        // return root

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                q.add(node.left);

            }
            if (node.right != null) {
                q.add(node.right);

            }
        }
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
