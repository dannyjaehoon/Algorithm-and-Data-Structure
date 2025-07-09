select id
     , case when MOD(id,2) = 1 AND id = (select MAX(id) from Seat) Then student
            when MOD(id,2) = 1 Then Lead(student) over (order by id)
            when MOD(id,2) = 0 Then Lag(student) over (order by id)
            else student
    END AS student
from Seat

