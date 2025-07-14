delete p1
 from Person p1
 join Person p2
   on p1.id > p2.id
  and p1.email = p2.email


DELETE FROM Person
WHERE id NOT IN (
    SELECT * FROM (
      SELECT MIN(id)
      FROM Person
      GROUP BY email
  ) AS tmp
);