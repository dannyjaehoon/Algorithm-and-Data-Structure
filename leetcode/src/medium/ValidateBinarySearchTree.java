package medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        // for BST, use the inorder traversal to get the sorted values

        createSortedArray(root);

        for(int i = 1; i <list.size(); i++) {
            if(list.get(i -1) >= list.get(i)) return false;
        }
        return true;
    }

    public void createSortedArray(TreeNode root) {
        if(root == null) return;

        createSortedArray(root.left);
        list.add(root.val);
        createSortedArray(root.right);
    }



    // optimized solution
    TreeNode prev = null;
    public boolean isValidBSTOpti(TreeNode root) {
        // for BST, use the inorder traversal to get the sorted values
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if(root == null) return true;

        if(!inorder(root.left)) return false;
        if(prev != null && prev.val >= root.val) return false;

        prev = root;

        return inorder(root.right);
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
