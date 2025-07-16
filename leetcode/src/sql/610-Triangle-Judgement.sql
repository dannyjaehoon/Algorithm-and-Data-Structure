select x
     , y
     , z
     , case when x < y + z && y < x + z && z < x + y then 'Yes'
            else 'No'
    end as triangle
from Triangle;