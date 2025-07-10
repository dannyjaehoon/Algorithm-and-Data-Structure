# 📌 Priority Queue vs Heap

## 1. What is a Priority Queue?

- A **Priority Queue** is an **abstract data type (ADT)**.
- It allows elements to be added with a priority, and ensures that the **highest (or lowest) priority element is removed first**, not necessarily the one that was added first.
- Common operations:
    - `insert(element, priority)`
    - `peek()` → View the highest-priority element
    - `poll()` or `remove()` → Remove and return the highest-priority element

> 📌 Note: A priority queue does **not define how** the elements are stored — only what operations are supported.

---

## 2. What is a Heap?

- A **Heap** is a **concrete data structure** that is commonly used to implement a priority queue.
- It is a **complete binary tree** that maintains the heap property:
    - **Max-Heap**: parent node ≥ child nodes (largest element at the top)
    - **Min-Heap**: parent node ≤ child nodes (smallest element at the top)

- Time complexity:
    - Insertion: `O(log n)`
    - Removal (poll): `O(log n)`
    - Peek (view top element): `O(1)`

---

## 3. Relationship Between Priority Queue and Heap

- A **priority queue is an idea (ADT)**.
- A **heap is one of the most efficient ways to implement** that idea.
- Java’s `PriorityQueue` class (in `java.util`) is backed by a **min-heap**.

> Think of it like this:
> - **Priority Queue** = "What" (the concept)
> - **Heap** = "How" (the implementation)

---

## 4. Real-world Analogy: Hospital Triage

> **Hospital triage** is a good example of a priority queue in real life:
> - Patients are not treated based on arrival time, but **based on the severity of their condition**.
> - This mimics a priority queue where more urgent cases (higher priority) are handled first.
