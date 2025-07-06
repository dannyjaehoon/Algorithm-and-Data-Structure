# 🔎 Selection Sort

## 📖 Overview
**Selection Sort** is a simple comparison-based sorting algorithm.  
It works by repeatedly selecting the **minimum element** from the unsorted portion of the array and moving it to its correct position at the beginning.

It divides the array into two parts: **sorted (left)** and **unsorted (right)**, and gradually grows the sorted part by selecting the smallest value each time.

---

## 🛠 How It Works
- Start from the first element (index 0)
- Find the minimum element in the unsorted portion
- Swap it with the element at the current index
- Move to the next index and repeat the process
- Continue until the array is sorted

---

## 🧪 Time & Space Complexity

| Case        | Time Complexity | Notes                             |
|-------------|------------------|-----------------------------------|
| Best Case   | O(n²)            | No early exit optimization        |
| Average     | O(n²)            | Regardless of input order         |
| Worst Case  | O(n²)            |                                   |
| Space       | O(1)             | In-place sorting                  |
| Stable?     | ❌ No            | May reorder equal elements        |

---

## ✅ When to Use
- Simple and predictable sorting
- When memory usage must be minimal
- Good for small arrays or educational purposes

---

## ⚙️ How It Works (Ascending Order)

Given an array:  
`[5, 3, 8, 4, 2]`

### Pass 1 (index 0):
- Find minimum in `[5, 3, 8, 4, 2]` → `2`
- Swap 5 and 2 → `[2, 3, 8, 4, 5]`

### Pass 2 (index 1):
- Find minimum in `[3, 8, 4, 5]` → `3`
- Already in place → `[2, 3, 8, 4, 5]`

### Pass 3 (index 2):
- Find minimum in `[8, 4, 5]` → `4`
- Swap 8 and 4 → `[2, 3, 4, 8, 5]`

### Pass 4 (index 3):
- Find minimum in `[8, 5]` → `5`
- Swap 8 and 5 → `[2, 3, 4, 5, 8]` ✅ Sorted!

---

## 📚 References
- [GeeksforGeeks – Selection Sort](https://www.geeksforgeeks.org/selection-sort/)
- [Visualgo – Selection Sort Animation](https://visualgo.net/en/sorting)

