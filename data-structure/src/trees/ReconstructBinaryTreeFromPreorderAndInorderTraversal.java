package trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinaryTreeFromPreorderAndInorderTraversal {


    // The key approach is to use the preorder array to identify the root, and the inorder array to identify the left and right subtrees.

    // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // In a preorder traversal, the first element is always the root of the tree
    // in an inorder traversal, elements to the left of the root are in the left subtree, and elements to the right are in the right subtree

    // Identify the root from the preorder array.
    // Find the root's position in the inorder array to determine the sizes of left and right subtrees.
    // Recursively construct left and right subtrees using the corresponding portions of both arrays.


    //      3
    //  9       15 20 7

    //     3
    // 9       20
    //      15     7

    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node<Integer> constructBinaryTree(List<Integer> preorder, List<Integer> inorder) {
        // create a value-to-index map for inorder traversal : store the index of each value in the inorder traversal
        // define a recursive helper function
        // - preorder_start and preorder_end : the range of indices in the preorder array.
        // - inorder_start and inorder_end : the range of indices in the order array

        // base case : if the start index is greater than the end index for either array, we return none, as represents an empty subtree
        // identify the root : the first element in the current preorder range is always the root of the current subtree
        // find the root in inorder traversal : use the value-to-index map to quickly locate the root's position in the inorder array
        // calculate sizes of left and right subtrees : the number of elements to the left of the root in the in order array is the size of the left subtree.
        //                                              the remaining elements from the right subtree
        // recursively construct left and right subtrees
        // - for the left subtree, use the left portion of both preorder and inorder arrays
        // - for the right subtree, use the right portion of both preorder and inorder arrays
        // return the constructed node : create a new TreeNode with the root value and attach the left and right subtrees.
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.size(); i++) {
            hashMap.put(inorder.get(i), i);
        }
        
        return buildTreeRecurvise(preorder, inorder, hashMap,0, 0, inorder.size());
    }

    private static Node<Integer> buildTreeRecurvise(List<Integer> preorder, List<Integer> inorder, Map<Integer,Integer> inorderHashMap,int preorderStart, int inorderStart, int size) {
        if(size <= 0) return null;

        int rootValue = preorder.get(preorderStart);
        int inorderIndex = inorderHashMap.get(rootValue);
        int leftSize = inorderIndex - inorderStart;

        Node<Integer> left = buildTreeRecurvise(preorder,inorder, inorderHashMap, preorderStart + 1, inorderStart, leftSize);
        Node<Integer> right = buildTreeRecurvise(preorder, inorder, inorderHashMap, preorderStart + 1 + leftSize, inorderStart + 1, size - 1 - leftSize);
        return new Node<Integer>(rootValue, left, right);
    }

}
