package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // use the BFS approach
        // From the root to the leaf node, use the queue to track each level

        // while(!q.isEmpty())
        // 1. for loop - int i = 0 to the size of the queue
        // 2. add a node value to the list
        // 3. if(node.left != null) add the node.left to the queue
        // 4. if(node.right != null) add the node.right to the queue
        // 5. add the list to the res list
        // 5. return the res list

        // time-complexity - O(n) because we visit each node exactly once.
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(list);
        }
        return res;
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
