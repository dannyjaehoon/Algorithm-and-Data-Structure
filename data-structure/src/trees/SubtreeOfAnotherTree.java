package trees;

public class SubtreeOfAnotherTree {

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

    public static boolean subtreeOfAnotherTree(Node<Integer> root, Node<Integer> subRoot) {

        // To solve this problem, I need to check whether the subRoot tree exists as a subtree in the main tree
        // so, the main idea is that I traverse every node in the root tree, for each node, I check if the subtree starting from that node is idential to subroot

        // I used two recursive functions
        // isSubTree(root, subRoot)
        // - Traverse the main tree
        // - At each node, calls isSameTree to check if subTree matches

        // isSameTree(a,b)
        // Return true only if both trees are structurally identical and have the same node values

        // edge cases
        // if root is null but subRoot is not, we return false
        // if both are null, we consider it as match
        // and if values dont match or the structure is different, we return false

        // time complexity is O(m * n) in the worst case, where m is the number of nodes in the root tree, and n is the number of nodes in the subRoot tree.


        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;

        return subtreeOfAnotherTree(root.left, subRoot) || subtreeOfAnotherTree(root.right, subRoot);
    }

    public static boolean isSameTree(Node<Integer> root, Node<Integer> subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
