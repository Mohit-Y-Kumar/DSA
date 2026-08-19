# Write your MySQL query statement below
SELECT e.name
FROM Employee e
JOIN (
    SELECT managerId, COUNT(*) AS employee_count
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) subq
ON e.id = subq.managerId;

