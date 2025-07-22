
select sub.product_id as product_id
     , round(sub.avg_total_price,2) as average_price
from (
         select p.product_id as product_id
              , COALESCE(SUM(p.price * u.units) * 1.0 / SUM(u.units),0) as avg_total_price
         from Prices p
                  left join UnitsSold u
                            on p.product_id = u.product_id
                                and u.purchase_date between p.start_date and p.end_date
         group by p.product_id
     ) as sub

