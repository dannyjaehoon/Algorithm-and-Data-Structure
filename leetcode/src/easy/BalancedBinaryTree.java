package easy;

public class BalancedBinaryTree {
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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    private int dfs(TreeNode root) {
        // check it if root is null

        // leftNode = dfs(root.left);
        // rightNode = dfs(root.right)
        // leftNode - rightNode > 1 return -1;

        // return Math.max(leftNode, rightNode) + 1;

        // I use DFS to go all the way down to the leaf nodes first.
        // Then, as I come back up, I check the height of the left and right subtrees.
        // If the height difference is more than 1, I return -1 to mark it as unbalanced.
        // Once I get -1 from any part of the tree, I stop and return false.

        if(root == null) return 0;

        int leftNode = dfs(root.left);
        int rightNode = dfs(root.right);
        if(leftNode == -1 || rightNode == -1) return -1;
        if(Math.abs(leftNode - rightNode) > 1) return -1;

        return Math.max(leftNode, rightNode) + 1;
    }
}
