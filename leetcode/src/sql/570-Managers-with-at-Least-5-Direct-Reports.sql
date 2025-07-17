

select name
from Employee
where id in (
    select managerId
    from Employee
    group by managerId
    having count(managerId) > 4);


SELECT e1.name
FROM Employee e1
         JOIN (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) > 4
) e2
              ON e1.id = e2.managerId;

