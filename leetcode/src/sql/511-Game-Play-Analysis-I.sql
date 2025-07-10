

-- This query returns the first login date for each player
SELECT player_id,
       MIN(event_date) AS first_login  -- Get the earliest login date per player
FROM Activity
GROUP BY player_id;                    -- Group rows by player_id so we calculate MIN for each player



-- This query also returns the first login date for each player
-- but uses the ROW_NUMBER() window function to get the first row per player
SELECT player_id,
       event_date AS first_login       -- Select only the first login date per player
FROM (
         SELECT player_id,
                event_date,
                ROW_NUMBER() OVER (
                    PARTITION BY player_id      -- Reset row numbering for each player
                    ORDER BY event_date         -- Sort rows from earliest to latest per player
                ) AS rn                         -- Assign row numbers (1, 2, 3...) per player
         FROM Activity
     ) AS sub
WHERE rn = 1;                            -- Keep only the first row (i.e., earliest login) per player


select player_id
     , event_date as first_login
from (
         select player_id
              , event_date
              , row_number() over (partition by player_id order by event_date) as rn
         from Activity
     ) as sub
where rn = 1

;
