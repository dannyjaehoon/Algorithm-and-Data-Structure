# 🫧 Bubble Sort

## 📖 Overview
**Bubble Sort** is a simple comparison-based sorting algorithm.  
It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.  
This process is repeated until the list is sorted.

It's called "Bubble" sort because the larger elements gradually **"bubble up"** to the end of the list.

---

## 🛠 How It Works
- Compare each pair of adjacent items
- Swap them if they are in the wrong order
- Repeat the process for all elements until no swaps are needed

---

## 🧪 Time & Space Complexity

| Case        | Time Complexity | Notes                |
|-------------|------------------|----------------------|
| Best Case   | O(n)             | When already sorted  |
| Average     | O(n²)            |                     |
| Worst Case  | O(n²)            | Reverse sorted       |
| Space       | O(1)             | In-place sorting     |
| Stable?     | ✅ Yes            | Maintains equal order|

---

## ✅ When to Use
- For learning purposes or small datasets
- When simplicity is more important than performance

---

## ⚙️ How It Works (Ascending Order)

Given an array:  
`[5, 3, 8, 4, 2]`

### Pass 1:
- Compare 5 and 3 → swap → `[3, 5, 8, 4, 2]`
- Compare 5 and 8 → OK
- Compare 8 and 4 → swap → `[3, 5, 4, 8, 2]`
- Compare 8 and 2 → swap → `[3, 5, 4, 2, 8]`

### Pass 2:
- Compare 3 and 5 → OK
- Compare 5 and 4 → swap → `[3, 4, 5, 2, 8]`
- Compare 5 and 2 → swap → `[3, 4, 2, 5, 8]`

### Pass 3:
- Compare 3 and 4 → OK
- Compare 4 and 2 → swap → `[3, 2, 4, 5, 8]`

### Pass 4:
- Compare 3 and 2 → swap → `[2, 3, 4, 5, 8]` ✅ Sorted!