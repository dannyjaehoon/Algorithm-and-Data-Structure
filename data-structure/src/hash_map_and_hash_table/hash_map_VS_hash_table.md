# ⚖️ HashMap vs Hashtable

## 📖 Overview
`HashMap` and `Hashtable` are both Java Map implementations that store key-value pairs.  
However, they differ significantly in terms of **synchronization**, **null handling**, and **modern usage**.

---

## 🔍 Key Differences

| Feature            | HashMap                             | Hashtable                             |
|--------------------|--------------------------------------|----------------------------------------|
| **Thread-safe**     | ❌ Not thread-safe                   | ✅ Thread-safe (synchronized methods)   |
| **Performance**     | ✅ Faster (no locking)               | ❌ Slower (synchronized on every method) |
| **Null keys**       | ✅ Allows 1 null key                 | ❌ Not allowed                         |
| **Null values**     | ✅ Allows multiple null values       | ❌ Not allowed                         |
| **Iteration order** | ❌ Unordered                         | ❌ Unordered                           |
| **Legacy status**   | ✅ Modern (since JDK 1.2, Collections Framework) | ❌ Legacy (pre-JDK 1.2)         |
| **Use in new code** | ✅ Recommended                      | ❌ Deprecated for new development      |
| **Alternative**     | `ConcurrentHashMap` (for concurrency) | Also use `ConcurrentHashMap`         |

---

## 🚨 Important Notes

- **Thread Safety**:
    - `Hashtable` synchronizes every method → safe but **low performance**
    - `HashMap` is not synchronized → use **`Collections.synchronizedMap()`** or **`ConcurrentHashMap`** if needed

- **Null Handling**:
    - `HashMap` allows 1 `null` key and multiple `null` values
    - `Hashtable` throws `NullPointerException` if null is used as key or value

- **Modern Usage**
