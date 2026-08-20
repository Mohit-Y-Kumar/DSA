# Write your MySQL query statement below
SELECT e.employee_id, e.department_id
FROM Employee e
WHERE e.primary_flag = 'Y'
   OR (
       SELECT COUNT(*)
       FROM Employee e2
       WHERE e2.employee_id = e.employee_id
   ) = 1;