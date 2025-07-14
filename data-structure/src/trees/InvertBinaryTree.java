package trees;

public class InvertBinaryTree {
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

    public static Node<Integer> invertBinaryTree(Node<Integer> tree) {

        // I use a recursive approach. At each node, I recursively invert its left and right subtree first, and then swap them
        // so this is a post-order traversal since the children are processed before the current node.

        // time-complexity : O(n)

        if(tree == null) return null;

        Node<Integer> left = invertBinaryTree(tree.left);
        Node<Integer> right = invertBinaryTree(tree.right);

        tree.left= right;
        tree.right = left;

        return tree;
    }
}
