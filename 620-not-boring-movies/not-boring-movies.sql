# Write your MySQL query statement below
select id,movie,description,rating
from Cinema 
WHERE id % 2 = 1 && description != 'boring'
ORDER BY rating DESC