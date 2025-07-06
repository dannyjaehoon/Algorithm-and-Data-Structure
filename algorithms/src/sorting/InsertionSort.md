# 🪛 Insertion Sort

## 📖 Overview
**Insertion Sort** is a simple and intuitive comparison-based sorting algorithm.  
It builds the final sorted array one element at a time by **inserting** each element into its correct position relative to the already sorted portion on the left.

It works similarly to the way you might sort playing cards in your hand.

---

## 🛠 How It Works
- Start from the second element (index 1)
- Compare it with the elements to its left
- Shift all larger elements one position to the right
- Insert the current element into its correct position
- Repeat for all remaining elements

---

## 🧪 Time & Space Complexity

| Case        | Time Complexity | Notes                          |
|-------------|------------------|--------------------------------|
| Best Case   | O(n)             | Already sorted array           |
| Average     | O(n²)            | Random order                   |
| Worst Case  | O(n²)            | Reverse sorted                 |
| Space       | O(1)             | In-place sorting               |
| Stable?     | ✅ Yes           | Maintains relative order of equals |

---

## ✅ When to Use
- Small or nearly sorted datasets
- When stable, in-place sorting is needed
- Great for teaching and step-by-step tracing

---

## ⚙️ How It Works (Ascending Order)

Given an array:  
`[5, 3, 8, 4, 2]`

### Pass 1 (index 1, value 3):
- Compare with 5 → shift 5 → `[5, 5, 8, 4, 2]`
- Insert 3 → `[3, 5, 8, 4, 2]`

### Pass 2 (index 2, value 8):
- 8 > 5 → no change → `[3, 5, 8, 4, 2]`

### Pass 3 (index 3, value 4):
- Compare with 8 → shift 8 → `[3, 5, 8, 8, 2]`
- Compare with 5 → shift 5 → `[3, 5, 5, 8, 2]`
- Insert 4 → `[3, 4, 5, 8, 2]`

### Pass 4 (index 4, value 2):
- Shift 8, 5, 4, 3 → `[3, 4, 5, 8, 8] → [3, 4, 5, 5, 8] → ...`
- Insert 2 → `[2, 3, 4, 5, 8]` ✅ Sorted!

---

## 📚 References
- [GeeksforGeeks – Insertion Sort](https://www.geeksforgeeks.org/insertion-sort/)
- [Visualgo – Insertion Sort Animation](https://visualgo.net/en/sorting)

