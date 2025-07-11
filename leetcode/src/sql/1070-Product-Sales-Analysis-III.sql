-- Select the first year sales record for each product
SELECT
    s.product_id,
    s.year AS first_year,
    s.quantity,
    s.price
FROM Sales s
WHERE (s.product_id, s.year) IN (
    -- Subquery: get the earliest year per product
    SELECT
        product_id,
        MIN(year) AS min_year
    FROM Sales
    GROUP BY product_id
);
-- Pros: Simpler syntax, easy to read
-- Cons: Some databases (like PostgreSQL) may optimize this less efficiently than JOIN


select s.product_id
     , s.year as first_year
     , s.quantity
     , s.price
  from Sales s
  join (
    select product_id
        , MIN(year) as min_year
    from Sales
    group by product_id
  ) as s1
  on s.product_id = s1.product_id
  AND s.year = s1.min_year;

-- Pros: More explicit, sometimes better optimized
-- Cons: Slightly more verbose