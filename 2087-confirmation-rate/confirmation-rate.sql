# Write your MySQL query statement below
select s.user_id,
 COALESCE(
        ROUND(
            COALESCE(subq.confirmed_count, 0) / COALESCE(subq.total_count, 1),
            2
        ),
        0
    )AS  confirmation_rate
from Signups s
left join( 
    select c.user_id,
        SUM(c.action = 'confirmed') AS confirmed_count,
        COUNT(*) AS total_count
    from Confirmations c
    GROUP BY c.user_id
) subq
ON s.user_id = subq.user_id;


