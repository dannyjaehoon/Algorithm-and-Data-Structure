# 🔗 Linked List

## 📖 Overview
A **Linked List** is a linear data structure where each element (node) contains:
- **Data**: the value to store
- **Pointer(s)**: reference(s) to the next (and possibly previous) node(s)

Unlike arrays, linked lists **do not require contiguous memory allocation**, making insertions and deletions more memory-efficient in dynamic scenarios.

---

## 📌 Characteristics

| Operation                | Time Complexity | Notes |
|--------------------------|------------------|-------|
| Access by index          | ❌ Not supported | Must traverse from head |
| Search                   | O(n)             | Linear scan required |
| Insertion (at known node)| ✅ O(1)           | Requires pointer to target location or previous node |
| Deletion (at known node) | ✅ O(1)           | Requires pointer to previous node (for singly list) |

> ⚠️ Insertion and deletion are **O(1)** only if the target node (or its previous node) is already known.  
> Otherwise, traversal takes **O(n)** time to find the correct position.

---

## 📊 Types of Linked Lists

### 1. Singly Linked List
- Each node has a `data` and a `next` pointer
- Traversal is only possible in **one direction**
- Lightweight, but harder to traverse backward or delete without previous reference

### 2. Doubly Linked List
- Each node has `data`, `next`, and `prev` pointers
- Can be traversed **forward and backward**
- Slightly more memory usage but allows efficient backward traversal and deletion

### 3. Circular Linked List
- The **last node points back to the first**
- Can be singly or doubly circular
- Useful in applications like round-robin scheduling or infinite iteration

---

## 🚨 Cautions

- **Manual memory management** is required in languages without garbage collection (e.g., C/C++)
- **Null pointer bugs** can easily occur if pointers are mismanaged
- In Java or Python, garbage collectors handle memory cleanup, but avoid unnecessary references

💡 Use Cases
- Undo/Redo functionality in applications
- Browser history navigation
- Polynomial or sparse matrix representation
- Real-time task scheduling (circular lists)