# Write your MySQL query statement below
SELECT e.name
FROM Employee e
JOIN (
    SELECT managerId, COUNT(*) AS employee_count
    FROM Employee
    
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) subq
ON e.id = subq.managerId;

