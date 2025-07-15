package medium;

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //The left subtree of a node contains only nodes with smaller values.
        //The right subtree contains only nodes with larger values.

        // if both p and q are smaller than root, the LCA must be in the left subtree
        // if both are greater than root, the LCA must be in the right subtree
        // otherwise, they6 split at this node, which means this is the LCA

        // I implemented it recursively. At each step:
        // if both values are less than root, I go left
        // if both are greater, I go right
        // if they are on different sides or one equals the current node, I return the current node as the LCA.

        //        6
        //   2        8
        //0    4    7    9
        //   3   5

        // step at root = 6
        // p = 2, q = 8
        // 2 > 6
        // 8 < 6
        // return root

        //        6
        //   2        8
        //0    4    7    9
        //   3   5
        // p = 2, q = 4
        // 2 > 6
        // 4 > 6
        // lowestCommonAncestor(root.left, p, q);

        // root = 2
        // 2 == 2
        // 4 < 2
        // return root

        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p,q);
        }

        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
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
