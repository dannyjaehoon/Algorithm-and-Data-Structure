# Tree Data Structure 

## 1. What is a Tree?
- A tree is a non-linear hierarchical data structure

  - It is acyclic (doesn't contain any cycles);
  - There exists a path from the root to any node;
  - Has N - 1 edges, where N is the number of nodes in the tree; and
  - Each node has exactly one parent node with the exception of the root node

- One root node and each node can have child nodes
- key terms:
  - Root, Parent, Child, Sibling, Leaf, Dept, Height, Subtree

## 2. Binary Tree
- A tree where each node has **at most two children**
- Types :
  - Full Binary Tree : every node has 0 or 2 children
  - Complete Binary Tree : all levels filled except possibly the last, filled from left
  - Perfect Binary Tree: completely filled with all leaves at the same depth.

## 3. Tree Traversal

### Depth-First search (DFS)
- Preorder : root -> left -> right
- Inorder : left -> root -> right
- postorder : left -> right -> root

### Breadth-First search (BFS)
- Levelorder traversal (uses a queue)


## 4. Binary Search Tree (BST)
- A binary tree where:
  - Left child < Parent < Right child
- Operations:
  - Insert
  - Search
  - Delete
- Inorder traversal of BST returns sorted values.

## 5. Heap (Min-Heap / Max-Heap)
- Complete binary tree used to implement priority queues.
- Min-Heap: parent ≤ children (smallest element at root)
- Max-Heap: parent ≥ children (largest element at root)
- Operations: insert, peek, poll
- Already implemented ✅