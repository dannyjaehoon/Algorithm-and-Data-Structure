# 🗃️ Hashtable in Java

## 📖 Overview
`Hashtable<K, V>` is a **legacy class** in Java used to store key-value mappings.  
It is **thread-safe**, but generally **discouraged in favor of HashMap or ConcurrentHashMap**.

---

## 🛠 Basic Usage
```java
Map<String, Integer> table = new Hashtable<>();
table.put("apple", 2);
table.put("banana", 5);

System.out.println(table.get("apple"));        // 2
System.out.println(table.containsKey("banana")); // true