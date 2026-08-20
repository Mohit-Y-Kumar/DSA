# Write your MySQL query statement below
SELECT 
    id,
    CASE 
        -- If odd, get the next student. If there isn't one (odd total), keep current.
        WHEN MOD(id, 2) = 1 THEN COALESCE(LEAD(student) OVER (ORDER BY id), student)
        -- If even, get the previous student
        ELSE LAG(student) OVER (ORDER BY id)
    END AS student
FROM Seat;
