package trees.bst;

public class InsertIntoBST {

    // inorder
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

    public static Node<Integer> insertBst(Node<Integer> bst, int val) {
//        At each recursive step, I compare the input value with the current node.
//        If it's smaller, I go to the left.
//        If it's larger or equal, I go to the right.
//        When I hit a null spot, I create a new node there and link it back up via recursion.


        if(bst == null) return new Node<>(val);

        if(val < bst.val) {
            bst.left = insertBst(bst.left, val);
        } else {
            bst.right = insertBst(bst.right, val);
        }

        return bst;



    }

}
