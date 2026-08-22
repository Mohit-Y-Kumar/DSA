# Write your MySQL query statement below
with cte as (select person_name, turn,
sum(weight) over (order by turn ) as running_weight
from queue)

select c.person_name
from cte c
where running_weight<=1000
order by c.turn desc
limit 1

