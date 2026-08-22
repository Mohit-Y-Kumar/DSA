# Write your MySQL query statement below

select distinct num as ConsecutiveNums
from(
    select
 LAG(num) OVER (ORDER BY id) AS previous_num,
 Lead(num) OVER (ORDER BY id) AS next_num,
 num
from Logs
 )t

WHERE num = previous_num
  AND num = next_num;

