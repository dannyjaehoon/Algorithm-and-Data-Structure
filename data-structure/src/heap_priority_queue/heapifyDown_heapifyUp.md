# 🔄 Heapify Up & Heapify Down in Heaps

In a binary heap, we must maintain the heap property after insertion or removal.  
This is done using two core operations: `heapifyUp` and `heapifyDown`.

---

## 🔼 heapifyUp (a.k.a. bubble up, sift up)

### ✅ When is it used?
- After inserting a new element at the end of the heap.

### ⚙️ What does it do?
- Compares the newly added node with its parent.
- If the heap property is violated (e.g. in a min-heap, child < parent), it swaps them.
- Repeats this process up the tree until the heap is valid again.

### 🔢 Formula:
- `parentIndex = (childIndex - 1) / 2`

### 📌 Min-Heap Example:
```text
Insert 3 into heap: [1, 5, 6, 8]
→ Insert at end: [1, 5, 6, 8, 3]
→ Compare 3 with parent (5): 3 < 5 → swap
→ Heap becomes: [1, 3, 6, 8, 5]
→ Compare 3 with parent (1): OK → done
```

---

## 🔽 heapifyDown (a.k.a. bubble down, sift down)

### ✅ When is it used?
- After removing the root element (e.g. poll/delete in priority queue).

### ⚙️ What does it do?
- Replaces the root with the last element.
- Compares the new root with its children.
- If the heap property is violated (e.g. parent > child in a min-heap), it swaps with the smaller child.
- Repeats this process down the tree.

### 🔢 Formulas:
- `leftChild = 2 * index + 1`
- `rightChild = 2 * index + 2`

### 📌 Min-Heap Example:
```text
Initial heap: [1, 3, 6, 8, 5]
→ Remove root (1), replace with last element: [5, 3, 6, 8]
→ Compare 5 with children (3 and 6): 3 is smaller → swap
→ Heap becomes: [3, 5, 6, 8]
→ 5 is now a leaf → done
```

---

## 🧩 Summary Table

| Operation     | Trigger               | Direction       | Purpose                           |
|---------------|------------------------|------------------|------------------------------------|
| `heapifyUp`   | After `insert()`       | Bottom → Top     | Restore heap by moving node up     |
| `heapifyDown` | After `poll()`/`remove()` | Top → Bottom     | Restore heap by moving node down   |

---

## 💡 Java Code Snippets

```java
private void heapifyUp(int index) {
    while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (heap.get(index).priority >= heap.get(parentIndex).priority) break;
        swap(index, parentIndex);
        index = parentIndex;
    }
}
```

```java
private void heapifyDown(int index) {
    int size = heap.size();
    while (index < size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap.get(left).priority < heap.get(smallest).priority)
            smallest = left;
        if (right < size && heap.get(right).priority < heap.get(smallest).priority)
            smallest = right;

        if (smallest == index) break;
        swap(index, smallest);
        index = smallest;
    }
}
```
