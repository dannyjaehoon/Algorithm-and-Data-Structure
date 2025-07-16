select id
     , case when p_id IS NULL then 'Root'
            when id not in (select distinct p_id from Tree where p_id IS NOT NULL) then 'Leaf'
            else 'Inner'
    end as type
from Tree
order by id;
