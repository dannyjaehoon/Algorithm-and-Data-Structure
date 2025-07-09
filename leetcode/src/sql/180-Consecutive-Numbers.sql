

-- We need to use DISTINCT because if the same number appears four or more times in a row,
-- our join logic could produce multiple rows with the same result.

SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
         inner JOIN Logs l2 ON l1.id = l2.id - 1
         inner JOIN Logs l3 ON l1.id = l3.id - 2
WHERE l1.num = l2.num AND l2.num = l3.num;


-- LEAD() is a window function that allows you to access data from the next row within the same result set.
-- LEAD(column_name, offset, default_value) OVER (PARTITION BY ... ORDER BY ...)

select distinct num as ConsecutiveNums
from (
    select num
         , LEAD(num,1) over (order by id) as next1
         , LEAD(num,2) over (order by id) as next2
     from Logs
     ) as t
where num = next1 and num = next2;


