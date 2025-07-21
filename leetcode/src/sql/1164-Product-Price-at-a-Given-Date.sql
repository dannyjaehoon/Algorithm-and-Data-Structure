select product_id
     , coalesce(
        (select new_price
         from Products p2
         where p1.product_id = p2.product_id
           and change_date <= '2019-08-16'
         order by change_date desc
        limit 1
    )
     , 10) as price
from Products p1
group by product_id