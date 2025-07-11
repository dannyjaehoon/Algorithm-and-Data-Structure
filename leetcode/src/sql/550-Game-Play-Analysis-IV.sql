-- Calculate the fraction of players who logged in again
-- on the day immediately after their first login.

SELECT
    ROUND(
            -- Count how many players logged in again on the next day after first login
            COUNT(DISTINCT A.player_id) * 1.0 /
            -- Total number of distinct players in the Activity table
            (SELECT COUNT(DISTINCT player_id) FROM Activity),
            2
    ) AS fraction
FROM Activity A
-- Join with a subquery that finds each player's first login date
JOIN (
    SELECT
        player_id,
        MIN(event_date) AS event_date  -- first login date
    FROM Activity
    GROUP BY player_id
) AS B

-- Match only records where the activity date is exactly one day after the first login
  ON A.player_id = B.player_id
      AND DATEDIFF(A.event_date, B.event_date) = 1;
