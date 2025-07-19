
--
-- WHERE activity_date BETWEEN CURDATE() - INTERVAL 29 DAY AND CURDATE()
-- - Filters data from the most recent 30 days including today, based on the current system date.
-- (Useful for dynamic, daily-updating queries.)
--
-- WHERE DATEDIFF('2019-07-27', activity_date) BETWEEN 0 AND 29
-- - Calculates the number of days between each activity_date and '2019-07-27', and keeps only those within the last 30 days.
--
-- WHERE activity_date BETWEEN DATE_SUB('2019-07-27', INTERVAL 29 DAY) AND '2019-07-27'
-- - Selects records from the 30-day period ending on '2019-07-27', using DATE_SUB() for subtraction.
-- (Readable and commonly used for fixed date ranges.)
--
-- WHERE activity_date BETWEEN DATE('2019-07-27') - INTERVAL 29 DAY AND DATE('2019-07-27')
-- - Same logic as above, but uses direct date arithmetic. Returns rows from the 30-day period ending on '2019-07-27'.

SELECT activity_date as day,
       COUNT(DISTINCT user_id) AS active_users
FROM Activity
WHERE activity_date BETWEEN DATE('2019-07-27') - INTERVAL 29 DAY AND '2019-07-27'
GROUP BY activity_date
ORDER BY activity_date;


