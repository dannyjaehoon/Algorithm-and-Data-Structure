Write your MySQL query statement below
/*
--  Learning Points:
--   - Practice of self-join via subquery
--   - Importance of filtering out NULL managerId
--   - Comparing salary against another record using subquery
*/


select name as Employee
from Employee e1
where managerId IS NOT NULL
  and salary > (
    select salary
    from Employee e2
    where e1.managerId = e2.id
)
/*
 this one is slow because the subquery gets executed once for every row in the outer query
 so if the employee table has N rows, the subquery over e2 could be sanned N times
 this can lead to O(n2) time complexity in the worse case.
 */

/*
 This query performs better than a correlated subquery,
 because it uses a JOIN instead of executing a subquery for each row.

 Specifically:
 - It joins each employee (e1) with their manager (e2) using managerId
 - Then filters the rows where the employee earns more than their manager
 - Inner JOIN ensures employees with NULL managerId are not included and filtered out by the where condition
 */

select e1.name as Employee
  from Employee e1
  inner join Employee e2 on e1.managerId = e2.id
 where e1.salary > e2.salary;



