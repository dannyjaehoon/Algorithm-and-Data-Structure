# 🚶‍♂️ Queue

## 📖 Overview
A **Queue** is a linear data structure that follows the **First-In, First-Out (FIFO)** principle.

Elements are **added to the rear (enqueue)** and **removed from the front (dequeue)** — much like a real-life queue.

It is widely used in scheduling, buffering, and breadth-first traversal.

---

## 📌 Characteristics

| Operation      | Time Complexity | Notes                         |
|----------------|------------------|-------------------------------|
| Enqueue        | ✅ O(1)           | Insert element at the rear    |
| Dequeue        | ✅ O(1)           | Remove element from the front |
| Peek / Front   | ✅ O(1)           | Access front without removing |
| Search         | ❌ O(n)           | Not efficient for search      |
| Random Access  | ❌ Not supported  | No direct index access        |

> ⚠️ Queue does **not support random access** — only front and rear operations are allowed.

---

## 🔗 Common Use Cases

- **Task scheduling** (e.g., CPU scheduling, printer queue)
- **Breadth-First Search (BFS)**
- **Buffering data streams** (I/O buffers, pipelines)
- **Thread pools and producer-consumer patterns**
- **Rate limiting and throttling**

