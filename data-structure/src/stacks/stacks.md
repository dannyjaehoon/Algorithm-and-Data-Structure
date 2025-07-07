# 📚 Stack Data Structure (Java-focused)

## 🔹 Overview
- **Definition**: A linear data structure that follows the **Last In, First Out (LIFO)** principle.
- **Common Operations**:
    - `push(x)`: Add element to the top
    - `pop()`: Remove and return the top element
    - `peek()`: Return the top element without removing it
    - `isEmpty()`: Check if the stack is empty
    - `size()`: Return the number of elements

## 🔹 When to Use
- Validating balanced parentheses (e.g. `({[]})`)
- Implementing Depth-First Search (DFS)
- Evaluating postfix expressions (Reverse Polish Notation)
- Undo/Redo features in applications
- Reversing strings
- Tracking function calls (Call Stack)

## 📌 Characteristics

| Operation        | Time Complexity | Notes |
|------------------|------------------|-------|
| Push             | ✅ O(1)           | Add element to the top |
| Pop              | ✅ O(1)           | Remove element from the top |
| Peek / Top       | ✅ O(1)           | Access the top element |
| Search           | ❌ O(n)           | Not efficient for searching elements |
| Random Access    | ❌ Not supported | Can’t access arbitrary index |