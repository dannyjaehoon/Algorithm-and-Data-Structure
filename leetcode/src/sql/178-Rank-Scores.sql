

-- This query calculates a dense rank for each score without using window functions.
-- It works in any MySQL version, including versions before 8.0.

-- How it works:
-- For each score in the table (alias: a), we count how many distinct scores (from alias: b)
-- are greater than or equal to the current score.
-- This is done using a correlated subquery.
-- Since we use COUNT(DISTINCT b.score), tied scores will get the same rank.
-- The results are then ordered in descending order by score.

select a.score
     , (select count(distinct b.score)
        from Scores b
        where b.score >= a.score) as `rank`
from Scores a
order by score desc


select a.score
     , dense_rank() over (order by score desc) `rank`
from Scores a
