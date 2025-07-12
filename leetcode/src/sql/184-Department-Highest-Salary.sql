select D.name as Department
     , E.name as Employee
     , E.salary as Salary
from Employee E
         join Department D
              on E.departmentId = D.id
where (D.name, E.salary) in (
    select D1.name
         , MAX(E1.salary)
    from Employee E1
             join Department D1
                  on E1.departmentId = D1.id
    group by D1.name
)
