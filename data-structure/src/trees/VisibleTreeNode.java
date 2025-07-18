package trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class VisibleTreeNode {
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

    public static int visibleTreeNode(Node<Integer> root) {
        // Start maxSoFar with smallest integer value possible so any value root has is greater than it
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(Node<Integer> root, int maxValue) {
        if (root == null) return 0;

        int total = 0;
        if (root.val >= maxValue) {
            maxValue = root.val;
            total++;
        }

        total += dfs(root.left, maxValue);
        total += dfs(root.right, maxValue);

        return total;
    }

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        int res = visibleTreeNode(root);
        System.out.println(res);
    }
}
