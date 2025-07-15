package medium;

public class PathSum3 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // Treat every node as a potential starting point
        // From each node, perform a DFS to explore all downward paths and count how many of them sum up to the target.
        // I use a recursive helper to do this.

        if(root == null) return 0;

        dfs(root, targetSum); // check from each node

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long targetSum) {
        if(root == null) return;

        if(root.val == targetSum) count++;

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
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
