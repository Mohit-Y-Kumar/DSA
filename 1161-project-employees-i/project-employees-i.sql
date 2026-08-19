# Write your MySQL query statement below
select 
 p.project_id,
    COALESCE(
        ROUND(
            SUM(e.experience_years) / COUNT(e.employee_id),
            2
        ),
        0
    ) AS average_years
from  Project p
 left join  Employee e
    ON p.employee_id = e.employee_id
    GROUP BY p.project_id