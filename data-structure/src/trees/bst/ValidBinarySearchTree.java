package trees.bst;

public class ValidBinarySearchTree {

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

    private static Node<Integer> prev = null;
    public static boolean validBst(Node<Integer> root) {
        if(root == null) return true;

        if(!validBst(root.left)) return false;

        if(prev != null && prev.val > root.val) return false;

        prev = root;

        return validBst(root.right);
    }
}
