package hard;

import medium.ValidateBinarySearchTree;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        // I solve this problem using a bottom-up DFS approach.
        // At each node, I compute the maximum path sum of the left and right subtrees.
        // Then, I consider the case where the path goes through the current node — combining left + root + right.
        // I keep track of a global maxSum variable that stores the maximum seen so far.

        // While returning back to the parent, I can only choose one direction (left or right) plus the current node, since a valid path can't split in both directions.

        // Time complexity is O(n) because we visit each node once.

        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left= Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
    public class TreeNode {
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
