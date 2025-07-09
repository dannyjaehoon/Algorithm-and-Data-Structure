package medium;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class KthSmallestElementinaBST {

    private int res;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        count =0;
        dfs(root,k);
        return res;
    }

    private boolean dfs(TreeNode root, int k) {
        if(root == null) return false;

        if(dfs(root.left, k)) return true;

        count++;
        if(count == k) {
            res = root.val;
            return true;
        }
        return dfs(root.right, k);
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

    // Iterative method
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//
//        while(curr != null || !stack.isEmpty()) {
//            while(curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            curr = stack.pop();
//            k--;
//            if(k == 0) return curr.val;
//
//            curr = curr.right;
//        }
//        return -1;
//    }
}
