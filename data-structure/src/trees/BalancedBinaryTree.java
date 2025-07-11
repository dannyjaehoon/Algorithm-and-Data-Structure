package trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class BalancedBinaryTree {
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

    public static boolean isBalanced(Node<Integer> tree) {

        return dfs(tree) == -1 ? false : true;
    }

    private static int dfs(Node<Integer> tree) {
        //dfs(1)
        //├─ dfs(2)
        //│  ├─ dfs(3)
        //│  │  ├─ dfs(null) → 0
        //│  │  └─ dfs(null) → 0
        //│  │  → Math.abs(0 - 0) = 0 → OK → return 1
        //│  ├─ left = 1
        //│  └─ dfs(null) → 0 → right = 0
        //│  → Math.abs(1 - 0) = 1 → OK → return 2
        //├─ left = 2
        //└─ dfs(null) → 0 → right = 0
        //→ Math.abs(2 - 0) = 2 ❌ → return -1 (불균형 감지)


        //dfs(1)
        //├─ dfs(2) → dfs(null) + dfs(null) → 0 + 0 → return 1
        //├─ dfs(3) → dfs(null) + dfs(null) → 0 + 0 → return 1
        //→ Math.abs(1 - 1) = 0 → return 2

        if (tree == null) return 0;

        int left = dfs(tree.left);
        int right = dfs(tree.right);

        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
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
        Node<Integer> tree = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        boolean res = isBalanced(tree);
        System.out.println(res);
    }
}
