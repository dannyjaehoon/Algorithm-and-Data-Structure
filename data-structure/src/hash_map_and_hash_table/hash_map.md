# 📦 HashMap in Java

## 📖 Overview
`HashMap<K, V>` is a part of Java Collections Framework that stores key-value pairs.  
It is **not synchronized**, allows **null keys and values**, and provides **O(1)** average-case performance.

---

⏱ Time Complexity
| Operation       | Average Case | Worst Case (Many Collisions) |
| --------------- | ------------ | ---------------------------- |
| `put()`         | O(1)         | O(n)                         |
| `get()`         | O(1)         | O(n)                         |
| `remove()`      | O(1)         | O(n)                         |
| `containsKey()` | O(1)         | O(n)                         |

- HashMap performs in O(1) time if the hash function distributes keys evenly.



🧱 Collision Handling
Separate Chaining: Each bucket holds a chain (Linked List) of entries with the same index.
Open Addressing: find the next available index to store data

Resizing (Rehashing)
- Default initial capacity: 16
- Default load factor: 0.75

Resize is triggered when:
- size > capacity × loadFactor
- newCapacity = oldCapacity * 2;

