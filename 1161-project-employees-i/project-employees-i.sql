# Write your MySQL query statement below
select 
 p.project_id,
    COALESCE(
        ROUND(
            AVG(e.experience_years),
            2
        ),
        0
    ) AS average_years
from  Project p
 left join  Employee e
    ON p.employee_id = e.employee_id
    GROUP BY p.project_id