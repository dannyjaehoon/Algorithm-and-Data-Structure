
SELECT (
       SELECT DISTINCT salary
       FROM Employee
       ORDER BY salary DESC
       LIMIT 1 OFFSET 1
) AS SecondHighestSalary;


select (
       SELECT salary
       FROM (
                SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rk
                FROM Employee
            ) ranked
       WHERE rk = 2
   ) AS SecondHighestSalary

-- if the second highest salary does not exit, you can wrap the whole query in a subquery.
