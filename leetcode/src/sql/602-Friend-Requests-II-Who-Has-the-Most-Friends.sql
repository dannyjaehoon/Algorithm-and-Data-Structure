


select id
     , num
from (
         select RA.id as id
              , RA.idCount + coalesce(RA1.idCount,0) as num
         from (
                  select accepter_id as id
                       , count(accepter_id) as idCount
                  from RequestAccepted
                  group by accepter_id
              ) RA
                  left join (
             select requester_id as id
                  , count(requester_id) as idCount
             from RequestAccepted
             group by requester_id
         ) RA1 on RA.id = RA1.id

         union all

         select RA.id as id
              , RA.idCount + coalesce(RA1.idCount,0) as num
         from (
                  select requester_id as id
                       , count(requester_id) as idCount
                  from RequestAccepted
                  group by requester_id
              ) RA
                  left join (
             select accepter_id as id
                  , count(accepter_id) as idCount
             from RequestAccepted
             group by accepter_id
         ) RA1 on RA.id = RA1.id
     ) as sub
order by sub.num desc
    limit 1;

