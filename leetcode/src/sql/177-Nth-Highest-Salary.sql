-- Employee table:
-- +----+--------+
-- | id | salary | dense_rank    row_number.   rank
-- +----+--------+
-- | 1  | 100    | 5                  6          6
-- | 2  | 200    | 4                  5          5
-- | 3  | 300    | 3                  4          4
-- | 4  | 400    | 2                  3          2
-- | 5  | 400    | 2                  2          2
-- | 6  | 500    | 1                  1          1
-- +----+--------+

with cte_ranked_salaries as (
    select id
         , salary
         , dense_rank() over (order by salary desc) rnk
    from Employee
)

select MAX(salary) getNthHighestSalary
from cte_ranked_salaries
where rnk = N

