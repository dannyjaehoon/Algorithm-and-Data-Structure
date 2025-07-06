# 🗂️ Sorting Algorithms Overview

## 📌 1. Comparison-Based Sorting

| Algorithm         | Avg. Time Complexity | Worst Case | Space Complexity | Stable | Description |
|------------------|----------------------|-------------|------------------|--------|-------------|
| **Bubble Sort**   | O(n²)                | O(n²)       | O(1)             | ✅ Yes | Repeatedly compares and swaps adjacent elements |
| **Selection Sort**| O(n²)                | O(n²)       | O(1)             | ❌ No  | Selects the minimum element and places it in order |
| **Insertion Sort**| O(n²)                | O(n²)       | O(1)             | ✅ Yes | Inserts each element into its correct position |
| **Merge Sort**    | O(n log n)           | O(n log n)  | O(n)             | ✅ Yes | Divide and conquer approach |
| **Quick Sort**    | O(n log n)           | O(n²)       | O(log n)         | ❌ No  | Partition-based divide and conquer |
| **Heap Sort**     | O(n log n)           | O(n log n)  | O(1)             | ❌ No  | Uses heap data structure |
| **Tim Sort**      | O(n log n)           | O(n log n)  | O(n)             | ✅ Yes | Hybrid of merge sort and insertion sort |
| **Shell Sort**    | O(n log n) ~ O(n²)   | O(n²)       | O(1)             | ❌ No  | Generalization of insertion sort with gaps |

---

## 🚀 2. Non-Comparison-Based Sorting

> Efficient when working with integers or fixed formats.

| Algorithm         | Time Complexity      | Space Complexity | Stable | Description |
|------------------|----------------------|------------------|--------|-------------|
| **Counting Sort** | O(n + k)             | O(k)             | ✅ Yes | Good for small range integers |
| **Radix Sort**    | O(nk)                | O(n + k)         | ✅ Yes | Sorts numbers by digit (LSD or MSD) |
| **Bucket Sort**   | O(n + k)             | O(n + k)         | ✅ Yes | Ideal for uniformly distributed data |

---

## 🎯 Algorithm Selection Guide

| Situation                                | Recommended Algorithm(s)         |
|------------------------------------------|----------------------------------|
| Nearly sorted data                       | Insertion Sort, Tim Sort         |
| Memory-constrained environments          | Heap Sort, In-place Quick Sort   |
| Stable sorting required                  | Merge Sort, Counting Sort, Tim Sort |
| Sorting large datasets with small range  | Counting Sort, Radix Sort        |
| Fast average performance                 | Quick Sort, Merge Sort, Tim Sort |

---

## 📚 References
- [GeeksforGeeks - Sorting](https://www.geeksforgeeks.org/sorting-algorithms/)
- [Visualgo - Sorting Visualization](https://visualgo.net/en/sorting)

