package easy;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        //       1
        //   2.      2
        //3.  4   4.   3

        // isMirror(2, 2)
        // ├── isMirror(3, 3)
        // │   ├── isMirror(null, null) → true
        // │   └── isMirror(null, null) → true
        // │       → true
        // └── isMirror(4, 4)
        //     ├── isMirror(null, null) → true
        //     └── isMirror(null, null) → true
        //         → true

        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;

        return dfs(t1.left, t2.right) && dfs(t1.right,  t2.left);
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
