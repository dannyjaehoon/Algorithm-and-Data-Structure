# 📘 Arrays

## 🧠 Overview

- An array is a **contiguous block of memory** that stores elements of the same type.
- Provides **O(1)** access by index.
- Fixed size in most languages (e.g., Java, C).
- Use dynamic arrays like `ArrayList`, `Vector`, or `List` for flexible sizing.

---

## 📌 Key Characteristics

| Feature | Description |
|--------|-------------|
| Memory | Continuous block |
| Access by index | O(1) |
| Insert/Delete (middle) | O(n) |
| Space overhead | Low |
| Type consistency | Same type per array |
| Size | Usually fixed |

---

## ⏱️ Time Complexity Summary

| Operation | Time | Notes |
|-----------|------|-------|
| Access | O(1) | Direct index |
| Search | O(n) | Needs iteration |
| Insert at end | O(1) or O(n) | Depends on resizing |
| Insert/delete in middle | O(n) | Needs shifting |

---

## 🧠 Key Concepts

### 1. Arrays vs Linked Lists

| Feature | Array | Linked List |
|--------|-------|-------------|
| Access time | O(1) | O(n) |
| Insert/Delete | O(n) | O(1) if pointer known |
| Memory layout | Contiguous | Dispersed |
| Cache efficiency | High | Low |

---

### 2. Limitations of Arrays

- **Fixed size** (unless dynamic array is used)
- **Inefficient insertion/deletion** in the middle
- **Lack of flexibility** → prefer dynamic structures when needed

---

### 3. Dynamic Arrays

- Automatically resize as needed
- Examples: `ArrayList` (Java), `list` (Python), `vector` (C++)
- Internally backed by static arrays

| Feature | Description |
|---------|-------------|
| Initial capacity | Typically 10 |
| Growth strategy | ×1.5 or ×2 |
| Pros | Flexible sizing |
| Cons | Resize costs performance |

---

### 4. Array Patterns and Algorithms

| Pattern / Algorithm | Use Case |
|---------------------|----------|
| Two Pointers | Pairing, deduplication, merging |
| Sliding Window | Subarrays, max/min, averages |
| Prefix Sum | Range queries, cumulative sums |
| Binary Search | Sorted arrays |
| Kadane’s Algorithm | Maximum subarray sum |
| Dutch National Flag | 3-way partitioning |
| Array Rotation | In-place shift of elements |
| Merge Intervals | Interval management problems |

---

## ⚠️ Things to Watch Out For

- `IndexOutOfBoundsException` or invalid access
- Uninitialized values (null or garbage depending on language)
- **Shallow vs Deep copy**
- Multidimensional array iteration complexity

---

## 📚 Popular Interview Problems (LeetCode)

| # | Title | Concept |
|----|-------|---------|
| 1 | Two Sum | Hash + Array |
| 53 | Maximum Subarray | Kadane’s Algorithm |
| 121 | Best Time to Buy and Sell Stock | Sliding Window |
| 560 | Subarray Sum Equals K | Prefix Sum + HashMap |
| 238 | Product of Array Except Self | Prefix & Suffix |
| 26 | Remove Duplicates from Sorted Array | Two Pointers |
| 189 | Rotate Array | In-place logic |
| 41 | First Missing Positive | In-place Bucket Sort |
| 42 | Trapping Rain Water | Two Pointers / Stack |
| 15 | 3Sum | Sorting + Two Pointers |

---

## 🔧 Useful Array Utilities (Java)

```java
Arrays.sort(arr);                     // Sort array
Arrays.copyOf(arr, newLength);        // Copy array
Arrays.toString(arr);                 // Print array
System.arraycopy(src, sPos, dest, dPos, len); // Fast copy
Arrays.fill(arr, val);                // Fill with value
