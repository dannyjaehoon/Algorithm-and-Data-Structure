-- Problem: LeetCode 182 - Duplicate Emails

-- Solution 1: Self-Join
-- Learning Points:
--   - Self-joining the table on the `email` field
--   - Adding `p1.id != p2.id` to avoid matching a row with itself
--   - Using DISTINCT to avoid duplicate result rows
--   - Good for understanding join logic and data relationships

SELECT DISTINCT p1.email AS Email
FROM Person p1
         INNER JOIN Person p2 ON p1.email = p2.email AND p1.id != p2.id;

--  Note:
--   - This works well, but performance can degrade for large datasets
--   - It requires comparing each row with every other row
--   - Generally less efficient than GROUP BY




--  Solution 2: GROUP BY + HAVING
--  Learning Points:
--   - Grouping by `email` to count how many times each email appears
--   - Using HAVING to filter groups with count > 1
--   - Very efficient and concise
--   - Best choice when we only care about which emails are duplicated

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;

--  Performance:
--   - This is the most efficient and readable solution
--   - No need for self-joins or complex filters
--   - The SQL engine optimizes GROUP BY with indexes if available
