-- Problem: LeetCode 183 - Customers Who Never Order

-- Solution 1: NOT EXISTS
-- Learning Points:
-- - Uses a correlated subquery
-- - Efficient because EXISTS returns early once a match is found
-- - Safer than NOT IN (does not fail on NULLs)
-- - Easy to understand: return the customer only if no order exists

SELECT name AS Customers
FROM Customers c
WHERE NOT EXISTS (
  SELECT 1
  FROM Orders o
  WHERE o.customerId = c.id
);

-- Performance:
-- - Works well on large datasets if Orders.customerId is indexed
-- - Very robust across different database engines


-- Solution 2: LEFT JOIN + IS NULL
-- Learning Points:
-- - Uses LEFT JOIN to keep all customers even if they have no orders
-- - Filters out customers who have at least one matching order
-- - Simple to read and widely used in practice

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.id = o.customerId
WHERE o.customerId IS NULL;

-- Performance:
-- - Highly efficient with proper indexing
-- - Often preferred when also retrieving data from both tables

